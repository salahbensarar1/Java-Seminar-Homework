package com.example.securityrole;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.io.IOException;
import java.util.Collection;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class WebSecurityConfig {

    @Autowired private UserDetailsService userDetailsService;
    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(

                        auth -> auth
                                .requestMatchers("/css/**", "/js/**", "/images/**", "/resources/**").permitAll()
                                .requestMatchers("/resources/**", "/","/home").authenticated()
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/visitor/**").hasRole("VISITOR")
                                .requestMatchers("/matches").hasAnyRole("ADMIN", "USER")
                                .requestMatchers("/entries").hasRole("ADMIN")
                                .requestMatchers("/spectators").hasAnyRole("ADMIN", "VISITOR")
                                .requestMatchers("/contact", "/contact/**").permitAll()
                                .requestMatchers("/messages").hasRole("ADMIN")
                                .requestMatchers("/api/**").permitAll()
                )
                .formLogin(
                        form -> form
                                .loginPage("/login") // Specifies the custom login page URL
                                .permitAll()         // Allows everyone to access the login page
                                .successHandler(new AuthenticationSuccessHandler() {
                                    @Override
                                    public void onAuthenticationSuccess(
                                            HttpServletRequest request,
                                            HttpServletResponse response,
                                            Authentication authentication
                                    ) throws IOException {
                                        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

                                        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
                                            response.sendRedirect("/admin/dashboard");
                                        }else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_VISITOR"))) {
                                            response.sendRedirect("/visitor");
                                        } else {
                                            response.sendRedirect("/home");
                                        }
                                    }
                                })
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/")
                                .permitAll()
                );
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }
}
