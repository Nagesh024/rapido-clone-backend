package com.rapido.platformengineering.architecturereview.controller;

import com.rapido.platformengineering.architecturereview.entity.ArchitectureReview;
import com.rapido.platformengineering.architecturereview.service.ArchitectureReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/architecture")
public class ArchitectureReviewController {

    private final ArchitectureReviewService service;

    public ArchitectureReviewController(
            ArchitectureReviewService service) {

        this.service = service;
    }

    @PostMapping("/review")
    public ArchitectureReview createReview(
            @RequestBody ArchitectureReview review) {

        return service.create(review);
    }

    @GetMapping("/reviews")
    public List<ArchitectureReview> getReviews() {

        return service.findAll();
    }

    @PutMapping("/reviews/{id}/approve")
    public ArchitectureReview approve(
            @PathVariable Long id) {

        return service.approve(id);
    }
}