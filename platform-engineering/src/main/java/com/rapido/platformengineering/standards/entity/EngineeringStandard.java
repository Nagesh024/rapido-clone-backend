package com.rapido.platformengineering.standards.entity;

import com.rapido.platformengineering.standards.enums.StandardCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "engineering_standards")
public class EngineeringStandard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String standardName;

    @Enumerated(EnumType.STRING)
    private StandardCategory category;

    @Column(length = 5000)
    private String description;

    private String version;

    private String owner;

    private Boolean mandatory;

    public EngineeringStandard() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName;
    }

    public StandardCategory getCategory() {
        return category;
    }

    public void setCategory(StandardCategory category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean getMandatory() {
        return mandatory;
    }

    public void setMandatory(Boolean mandatory) {
        this.mandatory = mandatory;
    }
}