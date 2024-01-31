package org.example.gtgapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("isaac")
                .password("{noop}test123")
                .build();

        UserDetails mary = User.builder()
                .username("george")
                .password("{noop}test123")
                .build();

        UserDetails david = User.builder()
                .username("david")
                .password("{noop}test123")
                .build();

        return new InMemoryUserDetailsManager(john, mary, david);
    }
}
