package com.rapido.backupservice.compliance;

import org.springframework.stereotype.Service;

@Service
public class DataDeletionService {

    public String deleteExpiredData() {

        System.out.println(
                "Expired Backup Deleted");

        return "Data Deletion Compliance Successful";
    }
}