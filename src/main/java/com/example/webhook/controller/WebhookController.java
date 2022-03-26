package com.example.webhook.controller;

import com.example.webhook.email.EmailSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/webhook")
public class WebhookController {

    private final EmailSender emailSender;

    public WebhookController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping
    public ResponseEntity<Void> receiveFigmaWebhook(@RequestParam String s) {
        notifyAllDevelopers(s);
        return ResponseEntity.ok().build();
    }

    private void notifyAllDevelopers(String content) {
        emailSender.sendEmail("ostap.melnychuk.kn.2017@lpnu.ua", "Figma Notification", content, false);
    }
}
