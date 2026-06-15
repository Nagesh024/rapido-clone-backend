package com.rapido.backupservice.security;

import org.springframework.stereotype.Service;

@Service
public class IamValidationService {

    public String validatePermissions() {

        System.out.println(
                "IAM Validation Started");

        System.out.println(
                "IAM Validation Successful");

        return "IAM Permissions Valid";
    }
}