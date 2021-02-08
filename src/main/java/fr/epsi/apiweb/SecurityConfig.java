package fr.epsi.apiweb;

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
            "/webjars/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("*").permitAll();
//                .antMatchers(AUTH_WHITELIST).permitAll()
//                .antMatchers(HttpMethod.POST, "/games").permitAll()
//                .antMatchers(HttpMethod.GET, "/games/").permitAll()
//                .antMatchers("/**/*").permitAll();

    }
}