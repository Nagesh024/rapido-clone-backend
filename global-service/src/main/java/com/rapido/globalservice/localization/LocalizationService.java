package com.rapido.globalservice.localization;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizationService {

    private final MessageSource messageSource;

    public LocalizationService(
            MessageSource messageSource
    ) {
        this.messageSource = messageSource;
    }

    public String getMessage(
            String key,
            Locale locale,
            Object... args
    ) {

        return messageSource.getMessage(
                key,
                args,
                locale
        );
    }
}