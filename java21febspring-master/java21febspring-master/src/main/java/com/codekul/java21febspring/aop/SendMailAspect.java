package com.codekul.java21febspring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class SendMailAspect {

    @Autowired
    private JavaMailSender mailSender;

    @AfterReturning(value = "pointCut()",returning = "name")
    public void send(String name){
        sendMail(name);
        System.out.println("In send mail");
    }
    @Pointcut("execution(public String saveUser(..))")
    public void pointCut() {
    }
    private void sendMail(String name) {
        String from = "codekul.vaibhav@gmail.com";
        String to = "kanthaliadesh@gmail.com";

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject("This is a plain text email");
        message.setText("Hello"+ name +" This is a plain text email.");

        mailSender.send(message);
    }
}
