package com.dictionary.group;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"com.dictionary.group", "com.dictionary.amqp"})
@EnableFeignClients(basePackages = "com.dictionary.clients")
public class GroupApplication {
    public static void main(String[] args) {
        SpringApplication.run(GroupApplication.class, args);
    }
}
