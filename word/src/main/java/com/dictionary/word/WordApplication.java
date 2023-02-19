package com.dictionary.word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.dictionary.word"})
@EnableFeignClients(basePackages = "com.dictionary.clients")
public class WordApplication {
    public static void main(String[] args) {
        SpringApplication.run(WordApplication.class, args);
    }
}
