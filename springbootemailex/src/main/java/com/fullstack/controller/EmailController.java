package com.fullstack.controller;

import com.fullstack.model.EmailModel;
import com.fullstack.service.IEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@Slf4j
public class EmailController {

    @Autowired
    private IEmailService emailService;

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailModel emailModel) {
        log.info("########Sending Email to: " + emailModel.getToEmail());
        emailService.sendEmail(emailModel);

        return ResponseEntity.ok("Mail Sent Successfully");
    }
}
