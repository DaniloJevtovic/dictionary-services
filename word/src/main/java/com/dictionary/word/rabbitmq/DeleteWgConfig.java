package com.dictionary.word.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteWgConfig {

    @Value("${rabbitmq.exchanges.delete-wg}")
    private String exchange;

    @Value("${rabbitmq.queues.wg-queue}")
    private String queue;

    @Value("${rabbitmq.routing-keys.wg-key}")
    private String routingKey;

    @Bean
    public TopicExchange topicWgExchange() {
        return new TopicExchange(this.exchange);
    }

    @Bean
    public Queue deleteWgQueue() {
        return new Queue(this.queue);
    }

    @Bean
    public Binding deleteWgBinding() {
        return BindingBuilder
                .bind(deleteWgQueue())
                .to(topicWgExchange())
                .with(this.routingKey);
    }
}
