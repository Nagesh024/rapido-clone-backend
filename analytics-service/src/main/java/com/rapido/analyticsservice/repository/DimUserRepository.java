package com.rapido.analyticsservice.repository;

import com.rapido.analyticsservice.entity.DimUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DimUserRepository extends JpaRepository<DimUser, Long> {
}