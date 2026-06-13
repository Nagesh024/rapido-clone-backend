package com.rapido.globalservice.privacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentLogRepository
        extends JpaRepository<ConsentLog, Long> {
}