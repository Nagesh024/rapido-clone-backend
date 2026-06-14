package com.rapido.search.controller;

import com.rapido.search.dto.TrendingResponse;
import com.rapido.search.service.TrendingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class TrendingController {

    private final TrendingService service;

    public TrendingController(TrendingService service) {
        this.service = service;
    }

    @GetMapping("/trending")
    public TrendingResponse trending() {
        return service.getTrending();
    }
}