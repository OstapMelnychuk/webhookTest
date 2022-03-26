package com.example.webhook.email;

public interface EmailSender {
    void sendEmail(String to, String subject, String content, boolean isHtml);
}
