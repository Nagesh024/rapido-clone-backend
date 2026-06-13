package com.rapido.globalservice.search;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {

    private final SearchService service;

    public SearchController(
            SearchService service
    ) {
        this.service = service;
    }

    @PostMapping
    public SearchResponse search(
            @RequestBody SearchRequest request
    ) {

        return service.search(
                request
        );
    }
}