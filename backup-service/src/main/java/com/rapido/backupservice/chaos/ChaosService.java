package com.rapido.backupservice.chaos;

import org.springframework.stereotype.Service;

@Service
public class ChaosService {

    public String simulateNodeFailure() {

        System.out.println(
                "Chaos Test: Kubernetes Node Failure");

        return "Node Failure Simulated";
    }

    public String simulateDatabaseFailure() {

        System.out.println(
                "Chaos Test: Database Shutdown");

        return "Database Failure Simulated";
    }

    public String simulateKafkaFailure() {

        System.out.println(
                "Chaos Test: Kafka Broker Failure");

        return "Kafka Failure Simulated";
    }

    public String simulateNetworkLatency() {

        System.out.println(
                "Chaos Test: Network Latency");

        return "Network Latency Simulated";
    }
}