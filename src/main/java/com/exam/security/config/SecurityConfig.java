package com.exam.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;



@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserDetailsService userDetailService;
    private final CustomAuthenticationProvider authenticationProvider;
    private final CustomBasicAuthenticationEntryPoint basicAuthenticationEntryPoint = new CustomBasicAuthenticationEntryPoint();

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailService);
        authenticationManagerBuilder.authenticationProvider(authenticationProvider);
        return authenticationManagerBuilder.build();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .antMatchers("/user/join").permitAll()
                .anyRequest()
                .authenticated()
                .and().httpBasic().authenticationEntryPoint(basicAuthenticationEntryPoint)
                .and().exceptionHandling().authenticationEntryPoint(basicAuthenticationEntryPoint)
                .and().csrf().disable();

        return http.build();
    }


}
