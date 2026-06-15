package com.rapido.globalservice.search;

public class SearchResponse {

    private String countryCode;

    private String indexName;

    private String query;

    public SearchResponse() {
    }

    public SearchResponse(
            String countryCode,
            String indexName,
            String query
    ) {
        this.countryCode = countryCode;
        this.indexName = indexName;
        this.query = query;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getIndexName() {
        return indexName;
    }

    public String getQuery() {
        return query;
    }
}