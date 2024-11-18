package com.example.paxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PaxServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PaxServiceApplication.class, args);
    }

}
