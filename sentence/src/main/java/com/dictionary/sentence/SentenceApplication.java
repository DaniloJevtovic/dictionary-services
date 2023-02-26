package com.dictionary.sentence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.dictionary.sentence", "com.dictionary.amqp"})
@EnableFeignClients(basePackages = "com.dictionary.clients")
public class SentenceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SentenceApplication.class, args);
    }
}
