package com.rapido.globalservice.timezone;

public class CountryContext {

    private static final ThreadLocal<String> COUNTRY_CODE =
            new ThreadLocal<>();

    private CountryContext() {
    }

    public static void setCountryCode(
            String countryCode
    ) {
        COUNTRY_CODE.set(countryCode);
    }

    public static String getCountryCode() {
        return COUNTRY_CODE.get();
    }

    public static void clear() {
        COUNTRY_CODE.remove();
    }
}