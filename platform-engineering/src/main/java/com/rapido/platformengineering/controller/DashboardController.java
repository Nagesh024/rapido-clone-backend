package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.DashboardSummaryDTO;
import com.rapido.platformengineering.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service = new DashboardService();

    @GetMapping("/summary")
    public DashboardSummaryDTO summary() {
        return service.summary();
    }
}