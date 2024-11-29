package com.fullstack.controller;

import com.fullstack.model.EmailModel;
import com.fullstack.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Slf4j
public class EmailController {

//This code is for email api
    @Autowired
    private IEmailService emailService;

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailModel emailModel) {
        log.info("########Sending Email to: " + emailModel.getToEmail());

        log.info("########Sending Email CC: " + emailModel.getCcEmail().toString());
        emailService.sendEmail(emailModel);

        return new ResponseEntity<>("Mail Sent Successfully!", HttpStatus.OK);


    }
}
