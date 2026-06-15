package com.rapido.multitenantservice.service;

import com.rapido.multitenantservice.dto.RidePolicyRequest;
import com.rapido.multitenantservice.entity.RidePolicy;
import com.rapido.multitenantservice.repository.RidePolicyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RidePolicyService {

    private final RidePolicyRepository repository;

    public RidePolicyService(
            RidePolicyRepository repository) {
        this.repository = repository;
    }

    public RidePolicy save(
            String tenantId,
            RidePolicyRequest request) {

        RidePolicy policy =
                repository.findByTenantIdAndRideType(
                                tenantId,
                                request.getRideType())
                        .orElse(new RidePolicy());

        policy.setTenantId(tenantId);
        policy.setRideType(request.getRideType());
        policy.setBaseFare(request.getBaseFare());
        policy.setMaxDistance(request.getMaxDistance());
        policy.setCancellationFee(
                request.getCancellationFee());
        policy.setActive(request.getActive());

        return repository.save(policy);
    }

    public List<RidePolicy> getPolicies(
            String tenantId) {

        return repository.findByTenantId(tenantId);
    }
}