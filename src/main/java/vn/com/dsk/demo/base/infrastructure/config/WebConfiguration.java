package vn.com.dsk.demo.base.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {

    private static final String[] WHITE_LIST_URL = {"http://localhost:3000", "http://localhost:8080", "http://localhost:8081"};

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("", "/swagger-ui/index.html");
    }
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins(WHITE_LIST_URL)
                .allowedMethods("*")
//                .allowedOriginPatterns("http://*.example.com", "https://*.example.org")
                .allowCredentials(true);

    }
}