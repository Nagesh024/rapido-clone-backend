package com.rapido.multitenantservice.config;

import com.rapido.multitenantservice.service.SubscriptionPlanService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionPlanLoader
        implements CommandLineRunner {

    private final SubscriptionPlanService service;

    public SubscriptionPlanLoader(
            SubscriptionPlanService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        service.createDefaultPlans();

        System.out.println(
                "Subscription Plans Loaded");
    }
}