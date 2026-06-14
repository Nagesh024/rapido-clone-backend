package com.rapido.notificationservice.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public boolean sendEmail(String email, String title, String message) {

        System.out.println("Email sent to " + email);
        System.out.println("Subject: " + title);
        System.out.println("Message: " + message);

        return true;
    }
}