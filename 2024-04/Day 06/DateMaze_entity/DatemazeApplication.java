package com.datee.datemaze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DatemazeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatemazeApplication.class, args);
    }
}
