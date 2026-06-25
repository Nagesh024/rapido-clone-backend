package com.rapido.platformengineering.technologylifecycle.entity;

import com.rapido.platformengineering.technologylifecycle.enums.TechnologyStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "technology_catalog")
public class TechnologyCatalog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String technologyName;

    private String version;

    @Enumerated(EnumType.STRING)
    private TechnologyStatus status;

    private String owner;

    private String replacementTechnology;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public TechnologyStatus getStatus() {
        return status;
    }

    public void setStatus(TechnologyStatus status) {
        this.status = status;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getReplacementTechnology() {
        return replacementTechnology;
    }

    public void setReplacementTechnology(String replacementTechnology) {
        this.replacementTechnology = replacementTechnology;
    }
}