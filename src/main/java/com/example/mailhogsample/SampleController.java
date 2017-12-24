package com.example.mailhogsample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @Autowired
    private MailSender sender;

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/mail")
    public void sample() {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom("from.test.test@mail.com");
        msg.setTo("to.test.test@mail.com");
        msg.setSubject("テストメール");//タイトルの設定
        msg.setText("Spring Boot より本文送信"); //本文の設定

        this.sender.send(msg);
    }
}
