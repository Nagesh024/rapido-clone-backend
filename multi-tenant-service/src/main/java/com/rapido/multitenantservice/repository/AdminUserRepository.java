package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminUserRepository
        extends JpaRepository<AdminUser, Long> {
}