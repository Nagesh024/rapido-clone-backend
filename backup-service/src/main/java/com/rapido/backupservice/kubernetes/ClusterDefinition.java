package com.rapido.backupservice.kubernetes;

import com.rapido.backupservice.config.RegionConfig;

public class ClusterDefinition {

    public void createCluster(RegionConfig config) {

        System.out.println(
                "Creating Cluster: "
                        + config.getClusterName());

        System.out.println(
                "Region: "
                        + config.getRegionName());

        System.out.println(
                "Namespace: "
                        + config.getNamespace());
    }
}