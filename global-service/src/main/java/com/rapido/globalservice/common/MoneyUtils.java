package com.rapido.globalservice.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class MoneyUtils {

    private MoneyUtils() {
    }

    public static BigDecimal round(BigDecimal value) {

        if (value == null) {
            return BigDecimal.ZERO;
        }

        return value.setScale(
                2,
                RoundingMode.HALF_UP
        );
    }
}