package com.rapido.backupservice.cli;

public class CliRunner {

    public static void main(String[] args) {

        if (args.length == 0) {

            System.out.println(
                    "Usage: restore-database | failover-region | verify-cluster");

            return;
        }

        switch (args[0]) {

            case "restore-database":

                new RestoreDatabaseCommand().run();

                break;

            case "failover-region":

                new FailoverRegionCommand().run();

                break;

            case "verify-cluster":

                new VerifyClusterCommand().run();

                break;

            default:

                System.out.println(
                        "Unknown Command");
        }
    }
}