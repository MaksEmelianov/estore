package com.estore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EstoreApp {

    @GetMapping("/")
    public String hello() {
        return "Hello, user!";
    }

    public static void main(String[] args) {
        SpringApplication.run(EstoreApp.class, args);
        System.out.println("Connect to http://localhost:8080/beta/");
    }
}
