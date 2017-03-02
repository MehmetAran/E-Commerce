package com.ecommerce.core.security;

import com.ecommerce.core.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import javax.sql.DataSource;


/**
 * Created by gennt on 3/2/2017.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ClientService clientService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                    .httpBasic()
                .and().rememberMe().disable()
                .authorizeRequests()
                    .antMatchers("/api/client/**")
                        .fullyAuthenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new ClientUserService(clientService));
//                .jdbcAuthentication()
//                .dataSource(dataSource)
//        .usersByUsernameQuery("SELECT username, password FROM Client WHERE username=?")
//        .passwordEncoder(new StandardPasswordEncoder("secret"));

    }

}
