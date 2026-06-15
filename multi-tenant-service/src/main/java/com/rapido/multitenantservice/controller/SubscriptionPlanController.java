package com.rapido.multitenantservice.controller;

import com.rapido.multitenantservice.entity.SubscriptionPlan;
import com.rapido.multitenantservice.repository.SubscriptionPlanRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SubscriptionPlanController {

    private final SubscriptionPlanRepository repository;

    public SubscriptionPlanController(
            SubscriptionPlanRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/plans")
    public List<SubscriptionPlan> getPlans() {

        return repository.findAll();
    }
}