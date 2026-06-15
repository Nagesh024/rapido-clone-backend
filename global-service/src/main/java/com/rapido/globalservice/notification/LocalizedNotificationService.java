package com.rapido.globalservice.notification;

import com.rapido.globalservice.localization.LocalizationService;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class LocalizedNotificationService {

    private final LocalizationService localizationService;

    public LocalizedNotificationService(
            LocalizationService localizationService
    ) {
        this.localizationService =
                localizationService;
    }

    public String generateMessage(
            NotificationType type,
            String language,
            String otp
    ) {

        switch (type) {

            case RIDE_CONFIRMATION:

                return localizationService
                        .getMessage(
                                "notification.ride.confirmation",
                                new Locale(language)
                        );

            case OTP:

                return localizationService
                        .getMessage(
                                "notification.otp",
                                new Locale(language),
                                otp
                        );

            case PAYMENT_SUCCESS:

                return localizationService
                        .getMessage(
                                "notification.payment.success",
                                new Locale(language)
                        );

            case DRIVER_ARRIVED:

                return localizationService
                        .getMessage(
                                "notification.driver.arrived",
                                new Locale(language)
                        );

            default:

                throw new RuntimeException(
                        "Unsupported notification type"
                );
        }
    }
}