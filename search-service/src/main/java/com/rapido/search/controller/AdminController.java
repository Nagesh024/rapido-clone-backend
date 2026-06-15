package com.rapido.search.controller;

import com.rapido.search.service.ReindexService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ReindexService service;

    public AdminController(ReindexService service) {
        this.service = service;
    }

    @PostMapping("/reindex")
    public String reindex() {

        return service.rebuildIndex();
    }
}