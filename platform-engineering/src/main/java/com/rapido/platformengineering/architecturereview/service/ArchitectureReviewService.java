package com.rapido.platformengineering.architecturereview.service;

import com.rapido.platformengineering.architecturereview.entity.ArchitectureReview;
import com.rapido.platformengineering.architecturereview.enums.ReviewStatus;
import com.rapido.platformengineering.architecturereview.repository.ArchitectureReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArchitectureReviewService {

    private final ArchitectureReviewRepository repository;

    public ArchitectureReviewService(
            ArchitectureReviewRepository repository) {

        this.repository = repository;
    }

    public ArchitectureReview create(
            ArchitectureReview review) {

        review.setStatus(ReviewStatus.PENDING);

        return repository.save(review);
    }

    public List<ArchitectureReview> findAll() {

        return repository.findAll();
    }

    public ArchitectureReview approve(Long id) {

        ArchitectureReview review =
                repository.findById(id)
                        .orElseThrow();

        review.setStatus(ReviewStatus.APPROVED);

        return repository.save(review);
    }
}