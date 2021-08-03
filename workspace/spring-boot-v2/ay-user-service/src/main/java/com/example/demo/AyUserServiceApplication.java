package com.example.demo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class AyUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AyUserServiceApplication.class, args);
    }

}
