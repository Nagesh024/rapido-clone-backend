package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.entity.AuditEvent;
import com.rapido.analyticsservice.repository.AuditEventRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.util.List;

@Service
public class AuditExportService {

    private final AuditEventRepository auditEventRepository;

    public AuditExportService(
            AuditEventRepository auditEventRepository) {

        this.auditEventRepository =
                auditEventRepository;
    }

    public String exportAuditEvents() {

        String fileName =
                "audit-events.csv";

        try (FileWriter writer =
                     new FileWriter(fileName)) {

            writer.append(
                    "Id,EventType,Payload,CreatedAt\n");

            List<AuditEvent> events =
                    auditEventRepository.findAll();

            for (AuditEvent event : events) {

                writer.append(
                        String.valueOf(
                                event.getId()))
                        .append(",")

                        .append(
                                event.getEventType())
                        .append(",")

                        .append(
                                event.getPayload()
                                        .replace(",", ";"))
                        .append(",")

                        .append(
                                event.getCreatedAt()
                                        .toString())
                        .append("\n");
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Export Failed",
                    e);
        }

        return fileName;
    }
}