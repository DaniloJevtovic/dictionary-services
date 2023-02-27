package com.dictionary.sentence.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteDicConfig {

    @Value("${rabbitmq.exchanges.delete-dic-all}")
    private String exchange;

    @Value("${rabbitmq.queues.dic-sentence-queue}")
    private String queue;

    @Value("${rabbitmq.routing-keys.dic-key-all}")
    private String routingKey;

    @Bean
    public TopicExchange topicDicExchange() {
        return new TopicExchange(this.exchange);
    }

    @Bean
    public Queue deleteDicQueue() {
        return new Queue(this.queue);
    }

    @Bean
    public Binding deleteDicBinding() {
        return BindingBuilder
                .bind(deleteDicQueue())
                .to(topicDicExchange())
                .with(this.routingKey);
    }
}
