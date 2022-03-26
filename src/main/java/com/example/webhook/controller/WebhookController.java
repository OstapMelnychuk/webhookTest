package com.example.webhook.controller;

import com.example.webhook.email.EmailSender;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/webhook")
public class WebhookController {

    private final EmailSender emailSender;

    public WebhookController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<Void> receiveFigmaWebhook(@RequestBody Map<String, Object> payload) {
        notifyAllDevelopers(payload.toString());
        return ResponseEntity.ok().build();
    }

    private void notifyAllDevelopers(String content) {
        emailSender.sendEmail("ostap.melnychuk.kn.2017@lpnu.ua", "Figma Notification", content, false);
    }
}
