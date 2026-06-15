package com.rapido.backupservice.drill;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DisasterRecoveryDrillController {

    private final DisasterRecoveryDrillService drillService;

    public DisasterRecoveryDrillController(
            DisasterRecoveryDrillService drillService) {

        this.drillService = drillService;
    }

    @GetMapping("/drill/run")
    public String runDrill() {

        return drillService.runDrill();
    }
}