package com.rapido.platformengineering.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name="audit_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventType;

    private String actor;

    private String action;

    private LocalDateTime createdAt;

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
}