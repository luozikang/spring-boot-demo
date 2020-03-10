package org.lzk.activemq.dao;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @JmsListener(destination = "neo.topic",containerFactory = "topicListenerFactory")
    public void receiveTopic(String text) {
        System.out.println("Consumer topic msg : "+text);
    }
}