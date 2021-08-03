package com.example.demo.impl;

import com.example.demo.Producer.AyMoodProducer;
import com.example.demo.model.AyMood;
import com.example.demo.repository.AyMoodRepository;
import com.example.demo.service.AyMoodService;
import com.example.demo.service.AyUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyMoodServiceImpl implements AyMoodService {

    @Resource
    private AyMoodRepository ayMoodRepository;


    @Override
    public AyMood save(AyMood ayMood) {
        return ayMoodRepository.save(ayMood);
    }



    static final String queue = "ay.queue.asyn.save";
    @Resource
    private AyMoodProducer ayMoodProducer;
    @Override
    public String asynSave(AyMood ayMood) {
        ayMoodProducer.SendMessage(queue,ayMood);
        System.out.println("插入:"+ayMood.getContent()+"成功！！");
        return "success";
    }
}
