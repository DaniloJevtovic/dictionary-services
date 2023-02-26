package com.dictionary.sentence.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteSgConfig {

    @Value("${rabbitmq.exchanges.delete-sg}")
    private String exchange;

    @Value("${rabbitmq.queues.sg-queue}")
    private String queue;

    @Value("${rabbitmq.routing-keys.sg-key}")
    private String routingKey;

    @Bean
    public TopicExchange topicSgExchange() {
        return new TopicExchange(this.exchange);
    }

    @Bean
    public Queue deleteSgQueue() {
        return new Queue(this.queue);
    }

    @Bean
    public Binding deleteWgBinding() {
        return BindingBuilder
                .bind(deleteSgQueue())
                .to(topicSgExchange())
                .with(this.routingKey);
    }
}
