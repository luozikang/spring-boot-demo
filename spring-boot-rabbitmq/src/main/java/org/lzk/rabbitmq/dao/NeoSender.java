package org.lzk.rabbitmq.dao;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NeoSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(int i) {
        String context = "Spring boot neo queue"+" ****** "+i;
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("neo", context);
    }

}