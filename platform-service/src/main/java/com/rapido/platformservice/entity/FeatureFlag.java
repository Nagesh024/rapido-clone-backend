package com.rapido.platformservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "feature_flags")
public class FeatureFlag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String featureName;

    @Column(nullable = false)
    private Boolean enabled;

    public FeatureFlag() {
    }

    public FeatureFlag(Long id, String featureName, Boolean enabled) {
        this.id = id;
        this.featureName = featureName;
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}