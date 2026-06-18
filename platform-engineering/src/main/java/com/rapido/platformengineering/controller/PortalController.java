package com.rapido.platformengineering.controller;

import com.rapido.platformengineering.dto.PortalModuleDTO;
import com.rapido.platformengineering.service.PortalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portal")
public class PortalController {

    private final PortalService service;

    public PortalController(PortalService service) {
        this.service = service;
    }

    @GetMapping("/modules")
    public List<PortalModuleDTO> modules() {
        return service.getModules();
    }
}