package com.rapido.globalservice.localization;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/language")
public class LanguageDetectionController {

    private final LanguageDetectionService service;

    public LanguageDetectionController(
            LanguageDetectionService service
    ) {
        this.service = service;
    }

    @GetMapping("/detect")
    public LanguageDetectionResponse detect(
            @RequestParam(required = false)
            String userLanguage,

            @RequestParam(required = false)
            String countryCode,

            @RequestHeader(
                    value = "Accept-Language",
                    required = false
            )
            String acceptLanguage
    ) {

        String selected =
                service.detectLanguage(
                        userLanguage,
                        countryCode,
                        acceptLanguage
                );

        return new LanguageDetectionResponse(
                selected
        );
    }
}