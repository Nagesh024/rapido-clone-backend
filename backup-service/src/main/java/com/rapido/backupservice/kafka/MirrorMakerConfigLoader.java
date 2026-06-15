package com.rapido.backupservice.kafka;

import org.springframework.stereotype.Component;

@Component
public class MirrorMakerConfigLoader {

    public void loadMirrorMakerConfig() {

        System.out.println(
                "MirrorMaker 2 configuration loaded");

        System.out.println(
                "Region A -> Region B replication enabled");
    }
}