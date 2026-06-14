package com.rapido.adminservice.driverperformance;

import com.rapido.adminservice.audit.AuditService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin/drivers")
public class DriverPerformanceController {

    private final DriverPerformanceService driverPerformanceService;
    private final AuditService auditService;

    public DriverPerformanceController(DriverPerformanceService driverPerformanceService,
                                       AuditService auditService) {
        this.driverPerformanceService = driverPerformanceService;
        this.auditService = auditService;
    }

    @GetMapping("/test")
    public String test() {
        return "Driver Controller Working";
    }

    @GetMapping("/top-performing")
    public List<DriverLeaderboardResponse> getTopPerformingDrivers(
            @RequestParam(required = false) String region) {

        return driverPerformanceService.getTopPerformingDrivers(region);
    }

    @PutMapping("/suspend/{driverId}")
    public DriverSuspensionResponse suspendDriver(@PathVariable Long driverId) {

        auditService.log(
                "admin@rapido.com",
                "DRIVER_SUSPENSION",
                "Driver " + driverId + " suspended"
        );

        return new DriverSuspensionResponse(
                driverId,
                "SUSPENDED",
                "Driver suspended successfully"
        );
    }
}