package com.rapido.platformservice.service;

import com.rapido.platformservice.dto.AIOpsRecommendationResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AIOpsRecommendationService {

    public AIOpsRecommendationResponse analyzePlatform() {

        AIOpsRecommendationResponse response =
                new AIOpsRecommendationResponse();

        double cpu = 92.5;
        double memory = 88.4;
        long kafkaLag = 1250;
        double redisUsage = 91.8;
        double dbConnections = 95.2;

        List<String> recommendations = new ArrayList<>();

        if(cpu > 85){
            response.setScaleKubernetes(true);
            recommendations.add("Scale Kubernetes Deployment");
        }

        if(cpu > 90){
            response.setRestartPods(true);
            recommendations.add("Restart unhealthy Pods");
        }

        if(kafkaLag > 1000){
            response.setIncreaseKafkaPartitions(true);
            recommendations.add("Increase Kafka Partitions");
        }

        if(redisUsage > 85){
            response.setIncreaseRedisMemory(true);
            recommendations.add("Increase Redis Memory");
        }

        if(dbConnections > 90){
            response.setOptimizeDatabase(true);
            recommendations.add("Optimize PostgreSQL Database");
        }

        response.setRecommendations(recommendations);

        response.setAiOpsStatus("RECOMMENDATIONS_GENERATED");

        return response;
    }
}