package org.lzk.activemq.dao;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer2 {
    @JmsListener(destination = "neo.queue",containerFactory = "queueListenerFactory")
    public void receiveQueue(String text) {
        System.out.println("Consumer2 queue msg : "+text);
    }
}