package com.example.docker_test.collert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/amin")
public class test {
    @RequestMapping("/text")

    public void aa() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}

