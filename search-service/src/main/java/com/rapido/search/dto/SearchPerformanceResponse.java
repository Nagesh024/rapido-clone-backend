package com.rapido.search.dto;

public class SearchPerformanceResponse {

    private String averageSearchLatency;
    private String cacheHitRatio;
    private String queryThroughput;
    private String elasticsearchResponseTime;

    public String getAverageSearchLatency() {
        return averageSearchLatency;
    }

    public void setAverageSearchLatency(String averageSearchLatency) {
        this.averageSearchLatency = averageSearchLatency;
    }

    public String getCacheHitRatio() {
        return cacheHitRatio;
    }

    public void setCacheHitRatio(String cacheHitRatio) {
        this.cacheHitRatio = cacheHitRatio;
    }

    public String getQueryThroughput() {
        return queryThroughput;
    }

    public void setQueryThroughput(String queryThroughput) {
        this.queryThroughput = queryThroughput;
    }

    public String getElasticsearchResponseTime() {
        return elasticsearchResponseTime;
    }

    public void setElasticsearchResponseTime(String elasticsearchResponseTime) {
        this.elasticsearchResponseTime = elasticsearchResponseTime;
    }
}