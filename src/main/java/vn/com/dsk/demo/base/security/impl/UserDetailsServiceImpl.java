package vn.com.dsk.demo.base.security.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.dsk.demo.base.domain.entities.Account;
import vn.com.dsk.demo.base.infrastructure.persistence.repository.AccountJpaRepository;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountJpaRepository accountJpaRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = new EmailValidator().isValid(username, null)
                ? accountJpaRepository.findOneWithAuthoritiesByEmail(username)
                : accountJpaRepository.findOneWithAuthoritiesByUsername(username);

        return account
                .map(this::createUserSecurity)
                .orElseThrow(() -> new UsernameNotFoundException("User '" + username + "' is not exist in system"));
    }

    private org.springframework.security.core.userdetails.User createUserSecurity(Account account){
        Set<GrantedAuthority> securityAuthorities = account
                .getAuthorities()
                .stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(account.getUsername(), account.getPassword(), securityAuthorities);

    }
}
