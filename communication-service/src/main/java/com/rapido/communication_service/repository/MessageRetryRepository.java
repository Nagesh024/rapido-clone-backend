package com.rapido.communication_service.repository;

import com.rapido.communication_service.entity.MessageRetry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRetryRepository extends JpaRepository<MessageRetry, Long> {

    List<MessageRetry> findByStatus(String status);
}