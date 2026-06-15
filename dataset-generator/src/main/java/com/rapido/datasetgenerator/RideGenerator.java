package com.rapido.datasetgenerator;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RideGenerator {

    @PostConstruct
    public void generateRides() throws Exception {

        Connection connection =
                DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/rapido_db",
                        "postgres",
                        "Nagesh2425");

        connection.setAutoCommit(false);

        String sql =
                """
                INSERT INTO rides
                (
                    user_id,
                    driver_id,
                    fare,
                    estimated_distance,
                    status,
                    requested_at
                )
                VALUES
                (?,?,?,?,?,?)
                """;

        PreparedStatement ps =
                connection.prepareStatement(sql);

        int batchSize = 10000;

        // TEST FIRST
        long totalRecords = 10000L;

        for (long i = 1; i <= totalRecords; i++) {

            ps.setLong(
                    1,
                    ThreadLocalRandom.current()
                            .nextLong(1, 10000001));

            ps.setLong(
                    2,
                    ThreadLocalRandom.current()
                            .nextLong(1, 1000001));

            ps.setDouble(
                    3,
                    ThreadLocalRandom.current()
                            .nextDouble(50, 1000));

            ps.setDouble(
                    4,
                    ThreadLocalRandom.current()
                            .nextDouble(1, 50));

            ps.setString(
                    5,
                    "REQUESTED");

            ps.setTimestamp(
                    6,
                    new Timestamp(
                            System.currentTimeMillis()));

            ps.addBatch();

            if (i % batchSize == 0) {

                ps.executeBatch();

                connection.commit();

                System.out.println(
                        "Inserted Rides = " + i);
            }
        }

        ps.close();
        connection.close();

        System.out.println(
                "Ride Generation Completed Successfully");
    }
}