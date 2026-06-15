package com.rapido.multitenantservice.repository;

import com.rapido.multitenantservice.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository
        extends JpaRepository<Role, Long> {
}