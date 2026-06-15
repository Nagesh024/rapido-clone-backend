package com.rapido.search.controller;

import com.rapido.search.model.LocationDocument;
import com.rapido.search.service.AutoCompleteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class AutoCompleteController {

    private final AutoCompleteService service;

    public AutoCompleteController(
            AutoCompleteService service) {
        this.service = service;
    }

    @GetMapping("/autocomplete")
    public List<LocationDocument> autocomplete(
            @RequestParam String q) {

        return service.search(q);
    }
}