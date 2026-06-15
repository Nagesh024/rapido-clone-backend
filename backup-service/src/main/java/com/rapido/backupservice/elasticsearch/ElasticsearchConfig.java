package com.rapido.backupservice.elasticsearch;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    public ElasticsearchConfig() {

        System.out.println(
                "Elasticsearch Primary Cluster Connected");

    }
}