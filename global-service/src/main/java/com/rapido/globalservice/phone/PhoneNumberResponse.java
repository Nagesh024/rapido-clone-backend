package com.rapido.globalservice.phone;

public class PhoneNumberResponse {

    private String originalNumber;

    private String countryCode;

    private Boolean valid;

    private String e164Number;

    public PhoneNumberResponse() {
    }

    public String getOriginalNumber() {
        return originalNumber;
    }

    public void setOriginalNumber(String originalNumber) {
        this.originalNumber = originalNumber;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getE164Number() {
        return e164Number;
    }

    public void setE164Number(String e164Number) {
        this.e164Number = e164Number;
    }
}