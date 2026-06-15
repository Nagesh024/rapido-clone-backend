package com.rapido.search.dto;

public class SearchMetricsResponse {

    private long totalSearches;
    private long totalLocations;
    private long totalDrivers;
    private long autocompleteRequests;
    private long fuzzySearchRequests;

    public long getTotalSearches() {
        return totalSearches;
    }

    public void setTotalSearches(long totalSearches) {
        this.totalSearches = totalSearches;
    }

    public long getTotalLocations() {
        return totalLocations;
    }

    public void setTotalLocations(long totalLocations) {
        this.totalLocations = totalLocations;
    }

    public long getTotalDrivers() {
        return totalDrivers;
    }

    public void setTotalDrivers(long totalDrivers) {
        this.totalDrivers = totalDrivers;
    }

    public long getAutocompleteRequests() {
        return autocompleteRequests;
    }

    public void setAutocompleteRequests(long autocompleteRequests) {
        this.autocompleteRequests = autocompleteRequests;
    }

    public long getFuzzySearchRequests() {
        return fuzzySearchRequests;
    }

    public void setFuzzySearchRequests(long fuzzySearchRequests) {
        this.fuzzySearchRequests = fuzzySearchRequests;
    }
}