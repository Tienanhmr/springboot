package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        DataSource dataSource = null;
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT user_id, password, is_active FROM members WHERE user_id=?")
                .authoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/admin/**")).hasRole("ADMIN")
                .dispatcherTypeMatchers(HttpMethod.valueOf("/catalog/**")).hasRole("SALE")
                .anyRequest().authenticated();

    }
}
