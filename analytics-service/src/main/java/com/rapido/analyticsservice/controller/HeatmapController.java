package com.rapido.analyticsservice.controller;

import com.rapido.analyticsservice.dto.HeatmapResponse;
import com.rapido.analyticsservice.service.HeatmapService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeatmapController {

    private final HeatmapService heatmapService;

    public HeatmapController(
            HeatmapService heatmapService) {

        this.heatmapService =
                heatmapService;
    }

    @GetMapping("/analytics/heatmap")
    public List<HeatmapResponse>
    getHeatmap() {

        return heatmapService
                .getHeatmapData();
    }
}