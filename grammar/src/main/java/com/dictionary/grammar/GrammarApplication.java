package com.dictionary.grammar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.dictionary.grammar", "com.dictionary.amqp"})
@EnableFeignClients(basePackages = "com.dictionary.clients")
public class GrammarApplication {
    public static void main(String[] args) {
        SpringApplication.run(GrammarApplication.class, args);
    }
}
