package ru.itis.rasimusv.pdfgenerator.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String GREAT_QUEUE = "great";
    public static final String BAD_QUEUE = "bad";
    public static final String EXCHANGE = "exchange";

    @Value("${rabbit.host}")
    private String host;

    @Value("${rabbit.port}")
    private Integer port;

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory(host, port);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    Queue youAreGreatQueue() {
        return new Queue(GREAT_QUEUE, false);
    }

    @Bean
    Queue badQueue() {
        return new Queue(BAD_QUEUE, false);
    }

    @Bean
    public Binding greatBinding(Queue youAreGreatQueue, DirectExchange exchange) {
        return BindingBuilder.bind(youAreGreatQueue).to(exchange).with(youAreGreatQueue.getName());
    }

    @Bean
    public Binding badBinding(Queue badQueue, DirectExchange exchange) {
        return BindingBuilder.bind(badQueue).to(exchange).with(badQueue.getName());
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}