package com.mycompany.RemoutedServiceRabbit.services;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service("receiverRabbit")
@RabbitListener(queues = "rabbitmq.queue")
public class ReceiverRabbit {

    @RabbitHandler
    public void handleMessage(Message message){
        System.out.println(message);
    }
}
