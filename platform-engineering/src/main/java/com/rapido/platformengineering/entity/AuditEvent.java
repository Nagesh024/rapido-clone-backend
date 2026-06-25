package com.rapido.platformengineering.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_events")
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

	public void setEventType(String type) {
		// TODO Auto-generated method stub
		
	}

	public void setActor(String actor2) {
		// TODO Auto-generated method stub
		
	}

	public void setCreatedAt(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}

	public void setEventType1(String type) {
		// TODO Auto-generated method stub
		
	}
}