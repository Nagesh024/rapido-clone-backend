package com.rapido.backupservice;

import com.rapido.backupservice.config.RegionConfig;
import com.rapido.backupservice.kubernetes.ClusterDefinition;

public class MultiRegionInfrastructureApp {

    public static void main(String[] args) {

        ClusterDefinition clusterDefinition =
                new ClusterDefinition();

        RegionConfig regionA =
                new RegionConfig(
                        "region-a",
                        "rapido-primary-cluster",
                        "rapido-region-a");

        RegionConfig regionB =
                new RegionConfig(
                        "region-b",
                        "rapido-secondary-cluster",
                        "rapido-region-b");

        clusterDefinition.createCluster(regionA);

        clusterDefinition.createCluster(regionB);

        System.out.println(
                "Multi-region infrastructure initialized");
    }
}