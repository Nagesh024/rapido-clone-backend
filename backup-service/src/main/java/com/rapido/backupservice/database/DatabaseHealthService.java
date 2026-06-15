package com.rapido.backupservice.database;

import org.springframework.stereotype.Service;

@Service
public class DatabaseHealthService {

    public boolean isPrimaryHealthy() {

        System.out.println(
                "Checking Primary Database");

        return false;
    }
}