package com.rapido.notificationservice.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class SmsService {

    public boolean sendSms(String phoneNumber, String message) {

        Random random = new Random();
        boolean success = random.nextBoolean();

        if (success) {
            System.out.println("SMS sent to " + phoneNumber + " : " + message);
            return true;
        } else {
            System.out.println("SMS FAILED for " + phoneNumber);
            return false;
        }
    }
}