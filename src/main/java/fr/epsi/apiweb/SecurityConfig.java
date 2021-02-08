package fr.epsi.apiweb;

import org.apache.http.auth.AUTH;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs/",
            "/webjars/**",
            "/games/*",
            "/games"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.POST, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.PUT, AUTH_WHITELIST).permitAll()
                .antMatchers("/**/*").permitAll();

    }
}