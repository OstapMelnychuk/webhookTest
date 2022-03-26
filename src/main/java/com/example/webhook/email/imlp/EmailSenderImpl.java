package com.example.webhook.email.imlp;

import com.example.webhook.email.EmailSender;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
@AllArgsConstructor
public class EmailSenderImpl implements EmailSender {

    private final JavaMailSender emailSender;

    @Override
    public void sendEmail(String to, String subject, String content, boolean isHtml) {
        try {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("ostapss222@gmail.com");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, isHtml);

        emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
