package com.example.demo.Producer;

import com.example.demo.model.AyMood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.attribute.standard.Destination;

@Service
public class AyMoodProducer {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private JmsTemplate jmsTemplate;
    public void SendMessage(String destination,final String message){
        jmsMessagingTemplate.convertAndSend(String.valueOf(destination),message);

    }
    public void SendMessage(String destination,final AyMood ayMood){
        //jmsMessagingTemplate.convertAndSend(destination,ayMood);
        jmsTemplate.convertAndSend(destination, ayMood.toString());

    }

}
