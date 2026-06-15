package com.rapido.analyticsservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "dim_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DimUser {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    private String email;

    private String city;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}