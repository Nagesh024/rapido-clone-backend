package com.rapido.globalservice.search;

import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private final CountryIndexResolver
            indexResolver;

    public SearchService(
            CountryIndexResolver indexResolver
    ) {
        this.indexResolver =
                indexResolver;
    }

    public SearchResponse search(
            SearchRequest request
    ) {

        String index =
                indexResolver.resolveIndex(
                        request.getCountryCode()
                );

        return new SearchResponse(
                request.getCountryCode(),
                index,
                request.getQuery()
        );
    }
}