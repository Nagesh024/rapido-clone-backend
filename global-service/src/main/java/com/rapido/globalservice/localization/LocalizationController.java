package com.rapido.globalservice.localization;

import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
@RequestMapping("/localization")
public class LocalizationController {

    private final LocalizationService service;

    public LocalizationController(
            LocalizationService service
    ) {
        this.service = service;
    }

    @GetMapping("/message")
    public String getMessage(
            @RequestParam String key,
            @RequestParam String lang
    ) {

        return service.getMessage(
                key,
                new Locale(lang)
        );
    }
}