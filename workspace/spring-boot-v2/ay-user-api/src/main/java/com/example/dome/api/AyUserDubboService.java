package com.example.dome.api;

import com.example.dome.domain.AyUser;

public interface AyUserDubboService {
    AyUser FindBuUserNameAndPassword(String name,String password);
}
