package com.rapido.backupservice.elasticsearch;

import org.springframework.stereotype.Service;

@Service
public class ReplicationService {

    public void replicateIndexes() {

        System.out.println(
                "Cross Cluster Replication Running");

    }
}