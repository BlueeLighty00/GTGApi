package org.example.gtgapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails isaac = User.builder()
                .username("isaac")
                .password(passwordEncoder().encode("test123"))
                .build();

        UserDetails george = User.builder()
                .username("george")
                .password(passwordEncoder().encode("test123"))
                .build();

        UserDetails david = User.builder()
                .username("david")
                .password(passwordEncoder().encode("test123"))
                .build();

        return new InMemoryUserDetailsManager(isaac, george, david);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(antMatcher(HttpMethod.POST, "/*")).permitAll()
                                .requestMatchers(antMatcher(HttpMethod.POST, "/images/**")).permitAll()
                                .requestMatchers(antMatcher(HttpMethod.GET, "/images/**")).permitAll()
                                .requestMatchers("/static/**").permitAll()
                                .requestMatchers("/").permitAll()
                                .anyRequest().authenticated()
                ).csrf(AbstractHttpConfigurer::disable)
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .defaultSuccessUrl("/", true)
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );


        return http.build();
    }
}
