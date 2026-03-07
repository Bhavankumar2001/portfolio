package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.resend.Resend;
import com.resend.core.exception.ResendException;
import com.resend.services.emails.model.CreateEmailOptions;

@Service
public class EmailService {

    private final Resend resend = new Resend("YOUR_API_KEY");

    public void sendContactEmail(String name, String email, String message) throws ResendException {

        CreateEmailOptions params = CreateEmailOptions.builder()
                .from("Portfolio <onboarding@resend.dev>")
                .to("bhavankumar1862001@gmail.com")
                .subject("New Portfolio Contact")
                .html("<h3>New Message</h3>"
                        + "<p><b>Name:</b> " + name + "</p>"
                        + "<p><b>Email:</b> " + email + "</p>"
                        + "<p><b>Message:</b> " + message + "</p>")
                .build();

        resend.emails().send(params);
    }
}