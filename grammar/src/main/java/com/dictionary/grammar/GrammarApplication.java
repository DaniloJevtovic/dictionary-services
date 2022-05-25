package com.dictionary.grammar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GrammarApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrammarApplication.class, args);
    }
}
