package com.api.votingapi.services;

import com.api.votingapi.models.Choice;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChoiceServiceMQ {
    private final RabbitTemplate rabbitTemplate;


    @Autowired
    public ChoiceServiceMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingkey;

    public void send(Choice choice) {
        System.out.println("RoutingKey:" + routingkey);
        rabbitTemplate.convertAndSend(exchange, routingkey, choice);
    }
}
