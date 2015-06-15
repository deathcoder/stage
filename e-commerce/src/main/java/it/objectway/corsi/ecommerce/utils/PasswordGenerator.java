package it.objectway.corsi.ecommerce.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by stageusr2015 on 15/06/2015.
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        String password = "demouser";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println(hashedPassword);
    }

}