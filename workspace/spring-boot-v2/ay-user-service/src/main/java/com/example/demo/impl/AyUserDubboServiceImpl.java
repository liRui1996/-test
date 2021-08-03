package com.example.demo.impl;

import com.example.dome.api.AyUserDubboService;
import com.example.dome.domain.AyUser;
import org.apache.dubbo.config.annotation.Service;

//对外提供用户服务类
@Service(version = "1.0")
public class AyUserDubboServiceImpl implements AyUserDubboService {

    @Override
    public AyUser FindBuUserNameAndPassword(String name, String password) {
        AyUser ayUser = new AyUser();
        ayUser.setName("王五");
        ayUser.setPassword("123456");
        System.out.println(ayUser.toString());
        return ayUser;
    }
}
