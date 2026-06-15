package com.rapido.globalservice.phone;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/phone")
public class PhoneNumberController {

    private final PhoneNumberService service;

    public PhoneNumberController(
            PhoneNumberService service
    ) {
        this.service = service;
    }

    @GetMapping("/validate")
    public PhoneNumberResponse validate(

            @RequestParam String phoneNumber,

            @RequestParam String countryCode
    ) {

        return service.validate(
                phoneNumber,
                countryCode
        );
    }
}