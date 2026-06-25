package com.rapido.platformengineering.risk.service;

import com.rapido.platformengineering.risk.entity.RiskRegister;
import com.rapido.platformengineering.risk.repository.RiskRegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiskRegisterService {

    private final RiskRegisterRepository repository;

    public RiskRegisterService(
            RiskRegisterRepository repository) {

        this.repository = repository;
    }

    public RiskRegister save(
            RiskRegister riskRegister) {

        return repository.save(riskRegister);
    }

    public List<RiskRegister> findAll() {

        return repository.findAll();
    }
}