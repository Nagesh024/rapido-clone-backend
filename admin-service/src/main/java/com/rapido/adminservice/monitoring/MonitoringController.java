package com.rapido.adminservice.monitoring;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/metrics")
public class MonitoringController {

    @GetMapping
    public Map<String, Object> metrics() {

        Map<String, Object> response = new HashMap<String, Object>();

        response.put("fraudAlertsGenerated", 15);
        response.put("dailyRevenue", 50000);
        response.put("driverUtilization", "82%");
        response.put("rideCancellationRatio", "4.2%");

        return response;
    }

    @GetMapping("/test")
    public String test() {
        return "Monitoring Controller Working";
    }
}