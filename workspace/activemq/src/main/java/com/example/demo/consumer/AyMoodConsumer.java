package com.example.demo.consumer;

import com.example.demo.model.AyMood;
import com.example.demo.service.AyMoodService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class AyMoodConsumer {
    @JmsListener(destination = "ay.queue")
    public void receiveQueue(String text){
        System.out.println("用户：【"+text+"】");

    }

    @Resource
    private AyMoodService ayMoodService;
    @JmsListener(destination = "ay.queue.asyn.save")
    public void receviceQueue(AyMood ayMood){
        System.out.println(ayMood);
    //    ayMoodService.save(ayMood);


    }
}
