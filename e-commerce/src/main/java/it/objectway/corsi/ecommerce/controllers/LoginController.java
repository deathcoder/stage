package it.objectway.corsi.ecommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping(value = "/spring")
public class LoginController {
    @RequestMapping("/api/user")
    public Principal user(Principal user) {
        return user;
    }
}
