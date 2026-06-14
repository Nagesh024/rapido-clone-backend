package com.rapido.search.dto;

public class RecommendationAnalyticsResponse {

    private long totalRecommendationsServed;
    private long totalRecommendationClicks;
    private String clickThroughRate;
    private String mostRecommendedLocation;

    public long getTotalRecommendationsServed() {
        return totalRecommendationsServed;
    }

    public void setTotalRecommendationsServed(long totalRecommendationsServed) {
        this.totalRecommendationsServed = totalRecommendationsServed;
    }

    public long getTotalRecommendationClicks() {
        return totalRecommendationClicks;
    }

    public void setTotalRecommendationClicks(long totalRecommendationClicks) {
        this.totalRecommendationClicks = totalRecommendationClicks;
    }

    public String getClickThroughRate() {
        return clickThroughRate;
    }

    public void setClickThroughRate(String clickThroughRate) {
        this.clickThroughRate = clickThroughRate;
    }

    public String getMostRecommendedLocation() {
        return mostRecommendedLocation;
    }

    public void setMostRecommendedLocation(String mostRecommendedLocation) {
        this.mostRecommendedLocation = mostRecommendedLocation;
    }
}