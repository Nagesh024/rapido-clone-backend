package com.rapido.search.controller;

import com.rapido.search.model.LocationDocument;
import com.rapido.search.service.FuzzySearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class FuzzySearchController {

    private final FuzzySearchService service;

    public FuzzySearchController(
            FuzzySearchService service) {
        this.service = service;
    }

    @GetMapping("/fuzzy")
    public List<LocationDocument> fuzzySearch(
            @RequestParam String q) {

        return service.fuzzySearch(q);
    }
}