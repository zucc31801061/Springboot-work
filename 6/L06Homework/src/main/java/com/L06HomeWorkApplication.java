package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class L06HomeWorkApplication {
    public static void main(String[] args) {
        SpringApplication.run(L06HomeWorkApplication.class, args);
    }
}
