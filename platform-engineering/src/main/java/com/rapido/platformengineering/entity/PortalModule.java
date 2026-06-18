package com.rapido.platformengineering.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "portal_modules")
public class PortalModule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    public PortalModule() {
    }

    public Long getId() {
        return id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}