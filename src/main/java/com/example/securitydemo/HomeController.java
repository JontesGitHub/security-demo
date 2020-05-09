package com.example.securitydemo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome<h1>");
    }

    @GetMapping("/user")
    public String homeUser() {
        return ("<h1>Welcome User<h1>");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String homeAdmin() {
        return ("<h1>Welcome Admin<h1>");
    }
}
