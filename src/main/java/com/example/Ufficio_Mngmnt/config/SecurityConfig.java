package com.example.Ufficio_Mngmnt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// configurazione della sicurezza

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/css/**", "/js/**").permitAll() // Permetti accesso a login e risorse statiche
                .anyRequest().authenticated() // Richiedi autenticazione per tutte le altre richieste
            )
            .formLogin((form) -> form
                .loginPage("/login") // Pagina di login
                .defaultSuccessUrl("/", true) // Reindirizza dopo il login
                .permitAll()
            )
            .logout((logout) -> logout
                .logoutUrl("/logout") // logout
                .logoutSuccessUrl("/login?logout") // Reindirizza dopo il logout
                .permitAll()
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usa BCrypt per gestire password criptate
    }
}