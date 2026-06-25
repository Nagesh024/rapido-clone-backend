package com.rapido.platformengineering.risk.controller;

import com.rapido.platformengineering.risk.entity.RiskRegister;
import com.rapido.platformengineering.risk.service.RiskRegisterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/risk-register")
public class RiskRegisterController {

    private final RiskRegisterService service;

    public RiskRegisterController(
            RiskRegisterService service) {

        this.service = service;
    }

    @PostMapping
    public RiskRegister create(
            @RequestBody RiskRegister riskRegister) {

        return service.save(riskRegister);
    }

    @GetMapping
    public List<RiskRegister> getAll() {

        return service.findAll();
    }
}