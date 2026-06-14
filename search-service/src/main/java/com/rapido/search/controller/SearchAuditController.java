package com.rapido.search.controller;

import com.rapido.search.model.SearchAudit;
import com.rapido.search.service.SearchAuditService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchAuditController {

    private final SearchAuditService service;

    public SearchAuditController(
            SearchAuditService service) {
        this.service = service;
    }

    @GetMapping("/audit")
    public List<SearchAudit> audit() {

        return service.getAuditHistory();
    }
}