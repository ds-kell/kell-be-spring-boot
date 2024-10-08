package vn.com.dsk.demo.base.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityUtils {

    private SecurityUtils() {}

    public static Optional<String> getCurrentUserLogin(){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()));
    }

    private static String extractPrincipal(Authentication authentication) {
        if (authentication == null){
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails userDetails){
            return userDetails.getUsername();
        } else if (authentication.getPrincipal() instanceof String principal && !principal.isEmpty()){
            return principal;
        }
        return null;
    }

    public static Optional<String> getCurrentUserJwt (){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional
            .ofNullable(securityContext.getAuthentication())
            .filter(authentication -> authentication.getCredentials() instanceof String)
            .map(authentication -> (String) authentication.getCredentials());
    }
}
