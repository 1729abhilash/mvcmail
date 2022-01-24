package com.abhi.service;

//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.JavaMailSenderImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class LCAppEmailServiceImpl implements LCAppEmailService {


    @Autowired
    private JavaMailSender javaMailSenderImpl;

    @Override
    public void sendEmail(String userName, String userEmail, String text) {

        SimpleMailMessage newEmail=new SimpleMailMessage();
        newEmail.setTo(userEmail);
        newEmail.setSubject("Love calculator Application Result");
        newEmail.setText("hi "+userName+" The result predicted by the lc app is "+text);
      javaMailSenderImpl.send(newEmail);

    }
}
