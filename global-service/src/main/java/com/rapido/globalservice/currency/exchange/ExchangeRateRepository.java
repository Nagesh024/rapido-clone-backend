package com.rapido.globalservice.currency.exchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Optional;

public interface ExchangeRateRepository
        extends JpaRepository<ExchangeRate, Long> {

    Optional<ExchangeRate> findByBaseCurrencyAndTargetCurrencyAndRateDate(
            String baseCurrency,
            String targetCurrency,
            LocalDate rateDate
    );

    @Query("""
SELECT e
FROM ExchangeRate e
WHERE e.baseCurrency = :base
AND e.targetCurrency = :target
ORDER BY e.rateDate DESC
""")
    java.util.List<ExchangeRate> findLatest(
            String base,
            String target
    );
}