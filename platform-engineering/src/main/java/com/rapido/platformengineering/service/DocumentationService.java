package com.rapido.platformengineering.service;

import com.rapido.platformengineering.dto.DocumentationResponse;
import com.rapido.platformengineering.repository.DocumentationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentationService {

    private final DocumentationRepository repository;

    public DocumentationService(
            DocumentationRepository repository) {

        this.repository = repository;
    }

    public List<DocumentationResponse> getAll() {

        return repository.findAll()
                .stream()
                .map(doc ->
                        new DocumentationResponse(
                                doc.getId(),
                                doc.getTitle(),
                                doc.getCategory(),
                                doc.getContent()
                        ))
                .toList();
    }
}