package com.rapido.globalservice.phone;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import org.springframework.stereotype.Service;

@Service
public class PhoneNumberService {

    private final PhoneNumberUtil phoneUtil =
            PhoneNumberUtil.getInstance();

    public PhoneNumberResponse validate(
            String phoneNumber,
            String countryCode
    ) {

        PhoneNumberResponse response =
                new PhoneNumberResponse();

        response.setOriginalNumber(phoneNumber);
        response.setCountryCode(countryCode);

        try {

            Phonenumber.PhoneNumber parsed =
                    phoneUtil.parse(
                            phoneNumber,
                            countryCode
                    );

            boolean valid =
                    phoneUtil.isValidNumber(parsed);

            response.setValid(valid);

            if (valid) {

                response.setE164Number(
                        phoneUtil.format(
                                parsed,
                                PhoneNumberUtil.PhoneNumberFormat.E164
                        )
                );
            }

            return response;

        } catch (NumberParseException e) {

            response.setValid(false);

            return response;
        }
    }
}