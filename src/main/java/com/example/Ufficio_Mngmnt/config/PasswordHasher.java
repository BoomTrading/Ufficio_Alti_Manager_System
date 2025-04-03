package com.example.Ufficio_Mngmnt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordHasher {

     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usa BCrypt per gestire password criptate
    }
    public static void main(String[] args) {

        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String plainPassword = "manager"; // Sostituisci con la tua password in chiaro
        String hashedPassword = encoder.encode(plainPassword);
        System.out.println("");

        System.out.println("password hashata: " + hashedPassword);

        System.out.println("");

    }
}