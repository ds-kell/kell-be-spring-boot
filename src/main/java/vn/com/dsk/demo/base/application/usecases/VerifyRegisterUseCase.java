package vn.com.dsk.demo.base.application.usecases;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.com.dsk.demo.base.adapter.dto.request.RegisterInfo;
import vn.com.dsk.demo.base.adapter.dto.request.VerifyRegisterInfo;
import vn.com.dsk.demo.base.adapter.dto.response.JwtResponse;
import vn.com.dsk.demo.base.application.services.AuthService;
import vn.com.dsk.demo.base.application.services.RedisService;
import vn.com.dsk.demo.base.domain.entities.Account;
import vn.com.dsk.demo.base.infrastructure.exception.ServiceException;
import vn.com.dsk.demo.base.security.jwt.JwtUtils;
import vn.com.dsk.demo.base.shared.common.UseCase;

import java.util.Set;

@Service
@Slf4j
public class VerifyRegisterUseCase implements UseCase<Object, VerifyRegisterInfo> {

    private final RedisService redisService;

    private final AuthService authService;

    private final PasswordEncoder passwordEncoder;

    private final JwtUtils jwtUtils;

    public VerifyRegisterUseCase(AuthService authService, RedisService redisService, PasswordEncoder passwordEncoder, JwtUtils jwtUtils) {
        this.authService = authService;
        this.redisService = redisService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public Object execute(VerifyRegisterInfo verifyRegisterInfo) {
        RegisterInfo registerInfo = redisService.getRegisterInfoByToken(verifyRegisterInfo.getVerifyCode() + verifyRegisterInfo.getUsername());
        if (authService.checkEmailOrUserNameExistInSystem(registerInfo)) {
            throw new ServiceException("Email or username is existed in system!", "err.api.email-username-is-existed");
        }
        if (compareInfo(registerInfo, verifyRegisterInfo)) {
            try {
                Account account = new Account();
                account.setUsername(registerInfo.getUsername());
                account.setEmail(registerInfo.getEmail());
                account.setPassword(passwordEncoder.encode(registerInfo.getPassword()));
                account.setIsActive(1);
                Set<String> listAuthority = registerInfo.getAuthorities();
                if (listAuthority != null && !listAuthority.isEmpty()) {
                    account.setAuthorities(authService.getPermissionByName(listAuthority));
                }

                authService.registerNewAccount(account);
                return new JwtResponse(
                        jwtUtils.generateAccessToken(registerInfo.getUsername()),
                        jwtUtils.generateRefreshToken(registerInfo.getUsername()),
                        "Bearer",
                        registerInfo.getUsername(),
                        listAuthority != null ? listAuthority.stream().toList() : null);
            } catch (DataAccessException e) {
                log.error("Error saving user to the database", e);
                throw new ServiceException("Failed to add user", "err.api.failed-to-add-user");
            }
        } else {
            return "OTP incorrect";
        }
    }

    private boolean compareInfo(RegisterInfo registerInfo, VerifyRegisterInfo verifyRegisterInfo) {
        return registerInfo.getEmail().equals(verifyRegisterInfo.getEmail())
                && registerInfo.getUsername().equals(verifyRegisterInfo.getUsername())
                && registerInfo.getPassword().equals(verifyRegisterInfo.getPassword())
                && registerInfo.getAuthorities().equals(verifyRegisterInfo.getAuthorities());
    }
}