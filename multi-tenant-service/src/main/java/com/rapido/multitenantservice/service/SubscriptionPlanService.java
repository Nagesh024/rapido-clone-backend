package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.entity.SubscriptionPlan;
import com.rapido.multitenantservice.repository.SubscriptionPlanRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionPlanService {

    private final SubscriptionPlanRepository repository;

    public SubscriptionPlanService(
            SubscriptionPlanRepository repository) {
        this.repository = repository;
    }

    public void createDefaultPlans() {

        if (repository.count() > 0) {
            return;
        }

        SubscriptionPlan starter = new SubscriptionPlan();
        starter.setTenantId("SYSTEM");
        starter.setPlanName("STARTER");
        starter.setRideLimit(1000);
        starter.setDriverLimit(100);
        starter.setAnalyticsAccess(false);
        starter.setMlFeatures(false);

        repository.save(starter);

        SubscriptionPlan growth = new SubscriptionPlan();
        growth.setTenantId("SYSTEM");
        growth.setPlanName("GROWTH");
        growth.setRideLimit(10000);
        growth.setDriverLimit(1000);
        growth.setAnalyticsAccess(true);
        growth.setMlFeatures(false);

        repository.save(growth);

        SubscriptionPlan enterprise = new SubscriptionPlan();
        enterprise.setTenantId("SYSTEM");
        enterprise.setPlanName("ENTERPRISE");
        enterprise.setRideLimit(100000);
        enterprise.setDriverLimit(10000);
        enterprise.setAnalyticsAccess(true);
        enterprise.setMlFeatures(true);

        repository.save(enterprise);
    }
}