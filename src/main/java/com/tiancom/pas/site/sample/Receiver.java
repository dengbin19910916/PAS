package com.tiancom.pas.site.sample;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {
        System.out.println("接收到：<" + message + ">");
    }

    @RabbitListener(queues = "my-queue")
    public void receiveMessage2(String message) {
        System.out.println("Received <" + message + ">");
    }
}
