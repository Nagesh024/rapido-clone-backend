package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.DocumentationResponse;
import com.rapido.platformengineering.service.DocumentationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docs")
public class DocumentationController {

    private final DocumentationService service;

    public DocumentationController(
            DocumentationService service) {

        this.service = service;
    }

    @GetMapping
    public List<DocumentationResponse> getAll() {

        return service.getAll();
    }
}