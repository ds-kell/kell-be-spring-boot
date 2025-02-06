package vn.com.dsk.demo.base.application.usecases;

import org.springframework.stereotype.Service;
import vn.com.dsk.demo.base.adapter.dto.response.JwtResponse;
import vn.com.dsk.demo.base.application.services.AuthService;
import vn.com.dsk.demo.base.shared.common.UseCase;

@Service
public class RefreshTokenUseCase implements UseCase<JwtResponse, String> {

    private final AuthService authService;

    public RefreshTokenUseCase(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public JwtResponse execute(String refreshToken) {
        return authService.verifyCookieExpiration(refreshToken);
    }
}