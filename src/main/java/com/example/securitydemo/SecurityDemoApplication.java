package com.example.securitydemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityDemoApplication {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }


    @Bean
    public CommandLineRunner run(UserRepository userRepository) throws Exception {
        return (args) -> {
            userRepository.deleteAll();

            User user = new User();
            user.setPassword(passwordEncoder.encode("123"));
            user.setUsername("user");
            user.setRole("ROLE_USER");
            userRepository.save(user);

            User admin = new User();
            admin.setPassword(passwordEncoder.encode("123"));
            admin.setUsername("admin");
            admin.setRole("ROLE_ADMIN");
            userRepository.save(admin);


            System.out.println("fetching the users:");
            userRepository.findAll()
                    .forEach(u -> System.out.println(String.format("%s pass: %s, id: %s", u.getUsername(), u.getPassword(), u.getId())));
        };
    }

}
