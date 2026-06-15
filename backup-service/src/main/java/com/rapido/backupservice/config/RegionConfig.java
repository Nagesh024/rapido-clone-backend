package com.rapido.backupservice.config;

public class RegionConfig {



    private final String regionName;
    private final String clusterName;
    private final String namespace;

    public RegionConfig(
            String regionName,
            String clusterName,
            String namespace) {

        this.regionName = regionName;
        this.clusterName = clusterName;
        this.namespace = namespace;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getClusterName() {
        return clusterName;
    }

    public String getNamespace() {
        return namespace;
    }
}