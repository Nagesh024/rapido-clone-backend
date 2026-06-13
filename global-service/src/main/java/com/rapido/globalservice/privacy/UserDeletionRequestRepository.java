package com.rapido.globalservice.privacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDeletionRequestRepository
        extends JpaRepository<UserDeletionRequest, Long> {
}