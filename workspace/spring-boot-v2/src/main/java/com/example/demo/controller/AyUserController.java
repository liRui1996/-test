package com.example.demo.controller;

import com.example.demo.error.BusinessException;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/ayUser")
public class AyUserController {
    @Resource
    private AyUserService ayUserService;

//    @Reference(version = "1.0")
//    public AyUserDubboService ayUserDubboService;

    @RequestMapping("/test")
    public String test(Model model){
        List<AyUser> ayUserList = ayUserService.findAll();
        model.addAttribute("user",ayUserList);

//        ayUserDubboService.FindBuUserNameAndPassword("张三","123456");
        //throw new BusinessException("业务异常");
        return "ayUser";


    }
    @RequestMapping("findByNameAndPasswordRetry")
    public String findByNameAndPasswordRetry(Model model){
        AyUser ayUser = ayUserService.findByNameAndPasswordRetry("张三","123456");
        model.addAttribute("user",ayUser);
        return "retry";
    }
    @RequestMapping("/test1")
    public String test1(Model model){
        List<AyUser> ayUserList = ayUserService.findAll();
        model.addAttribute("user",ayUserList);

//        ayUserDubboService.FindBuUserNameAndPassword("张三","123456");
        //throw new BusinessException("业务异常");
        return "ayUser";


    }
    @RequestMapping("/test2")
    public String test2(Model model){
        List<AyUser> ayUserList = ayUserService.findAll();
        model.addAttribute("user",ayUserList);

//        ayUserDubboService.FindBuUserNameAndPassword("张三","123456");
        //throw new BusinessException("业务异常");
        return "ayUser";


    }

}
