package ru.itis.rasimusv.examproject.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.rasimusv.examproject.token.AccessTokenFilter;

@Configuration
public class AppConfig {

    private final AccessTokenFilter accessTokenFilter;

    public AppConfig(AccessTokenFilter accessTokenFilter) {
        this.accessTokenFilter = accessTokenFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FilterRegistrationBean<AccessTokenFilter> getTokenFilter()
    {
        FilterRegistrationBean<AccessTokenFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(accessTokenFilter);
        registrationBean.addUrlPatterns("/token");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
