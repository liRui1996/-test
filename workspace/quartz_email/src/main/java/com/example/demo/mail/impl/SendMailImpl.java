package com.example.demo.mail.impl;

import com.example.demo.mail.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Service
public class SendMailImpl implements SendMailService {

    @Autowired
    JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private  String from;
    @Override
    public boolean sendMail() throws MessagingException {

        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        System.out.println(from);
        //邮件发送方
        message.setFrom(from);
//        邮件主题
        message.setSubject("晚上吃啥");
//        邮件接收方
        message.setTo("614997394@qq.com");
//        邮件内容
        message.setText("你快想想晚上吃啥");
//        发送邮件
        this.mailSender.send(mimeMessage);
        return true;
    }
}
