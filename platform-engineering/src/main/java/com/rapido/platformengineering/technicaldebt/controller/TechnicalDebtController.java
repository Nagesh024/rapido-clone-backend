package com.rapido.platformengineering.technicaldebt.controller;

import com.rapido.platformengineering.technicaldebt.entity.TechnicalDebt;
import com.rapido.platformengineering.technicaldebt.dto.TechnicalDebtDashboardResponse;
import com.rapido.platformengineering.technicaldebt.service.TechnicalDebtService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technical-debt")
public class TechnicalDebtController {

    private final TechnicalDebtService service;

    public TechnicalDebtController(
            TechnicalDebtService service) {
        this.service = service;
    }

    @PostMapping
    public TechnicalDebt create(
            @RequestBody TechnicalDebt debt) {
        return service.save(debt);
    }

    @GetMapping
    public List<TechnicalDebt> getAll() {
        return service.findAll();
    }
    @GetMapping("/dashboard")
    public TechnicalDebtDashboardResponse dashboard() {
        return service.getDashboard();
    }@GetMapping("/paged")
    public List<TechnicalDebt> paged() {
        return service.findAll();
    }
}