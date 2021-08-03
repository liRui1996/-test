package com.example.demo.mail;

import javax.mail.MessagingException;

public interface SendMailService {
    boolean sendMail() throws MessagingException;
}
