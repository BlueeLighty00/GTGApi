package org.example.gtgapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(antMatcher(HttpMethod.POST, "/login")).permitAll()
                                .requestMatchers(antMatcher(HttpMethod.GET, "/login")).permitAll()
                                .requestMatchers(antMatcher(HttpMethod.POST, "/register")).permitAll()
                                .requestMatchers(antMatcher(HttpMethod.GET, "/register")).permitAll()
                                .requestMatchers(antMatcher(HttpMethod.GET, "/app/*")).hasAuthority("USER")
                                .anyRequest().authenticated()

                )
                .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }

}
