package com.example.demo.impl;

import com.example.demo.model.AyUserAttachmentRel;
import com.example.demo.repository.AyUserAttachmentRelRepository;
import com.example.demo.service.AyUserAttachmentRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyUserAttachmentRelImpl implements AyUserAttachmentRelService {
    @Resource
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;
    @Override
    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {

        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);

    }
}
