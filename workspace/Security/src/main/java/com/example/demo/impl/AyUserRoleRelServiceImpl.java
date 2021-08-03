package com.example.demo.impl;

import com.example.demo.model.AyUserRoleRel;
import com.example.demo.repository.AyUserRoleRelRepository;
import com.example.demo.service.AyUserRoleRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AyUserRoleRelServiceImpl implements AyUserRoleRelService {
    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;
    @Override
    public List<AyUserRoleRel> findByUserId(String userid) {

        return ayUserRoleRelRepository.findByUserId(userid);
    }
}
