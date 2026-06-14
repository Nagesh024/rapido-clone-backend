package com.rapido.search.service;

import com.rapido.search.model.LocationDocument;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuzzySearchService {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public FuzzySearchService(
            ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public List<LocationDocument> fuzzySearch(
            String keyword) {

        Criteria criteria =
                new Criteria("name")
                        .fuzzy(keyword);

        CriteriaQuery query =
                new CriteriaQuery(criteria);

        SearchHits<LocationDocument> hits =
                elasticsearchTemplate.search(
                        query,
                        LocationDocument.class
                );

        return hits.stream()
                .map(SearchHit::getContent)
                .toList();
    }
}