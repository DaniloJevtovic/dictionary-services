package com.dictionary.text;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.dictionary.text", "com.dictionary.amqp"})
@EnableFeignClients(basePackages = "com.dictionary.clients")
public class TextApplication {
    public static void main(String[] args) {
        SpringApplication.run(TextApplication.class, args);
    }
}
