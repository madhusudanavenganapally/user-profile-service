package com.vvr.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.vvr.group.repository")
public class UserProfileServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProfileServiceApplication.class, args);
    }
}