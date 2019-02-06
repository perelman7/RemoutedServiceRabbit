package com.mycompany.RemoutedServiceRabbit.services.receiveMessage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mycompany.RemoutedServiceRabbit.model.ChangeRow;
import com.mycompany.RemoutedServiceRabbit.services.modelService.DefaultChangeRowService;
import com.mycompany.RemoutedServiceRabbit.util.SequenceGeneratorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component("receiverRabbit")
public class ReceiverRabbit {

    @Autowired
    @Qualifier("changeRowService")
    private DefaultChangeRowService service;

    @Autowired
    @Qualifier("sequenceGeneratorService")
    private SequenceGeneratorService generatorService;

    @RabbitListener(queues = "rabbitmq.queue")
    public void handleMessage(String message){
        System.out.println(message);
        try{
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            ChangeRow changeRow = mapper.readValue(message, ChangeRow.class);
            changeRow.setId(generatorService.generateSequence(ChangeRow.SEQUENCE_NAME));
            System.out.println(changeRow);
            service.add(changeRow);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
