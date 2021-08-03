package com.example.demo.quartz;

import com.example.demo.mail.SendMailService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@Component
@Configuration
@EnableScheduling
public class SendMailQuartz {

//    没五秒运行一次

    @Resource
    SendMailService sendMailService;
    @Scheduled(cron = "*/5 * * * * *")
    public void reportCurrentByCron() throws MessagingException {

        System.out.println("注解式定时器运行起来了" );
        if(sendMailService.sendMail()){
            System.out.println("邮件发送成功");
        }

    }
}
