package com.rapido.datasetgenerator;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Component
public class RiderGenerator {

    @PostConstruct
    public void generate() throws Exception {

        Faker faker = new Faker();

        Connection connection =
                DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/rapido_db",
                        "postgres",
                        "Nagesh2425");

        PreparedStatement ps =
                connection.prepareStatement(
                        """
                        INSERT INTO riders
                        (
                        name,
                        email,
                        phone,
                        city,
                        rating,
                        latitude,
                        longitude
                        )
                        VALUES
                        (?,?,?,?,?,?,?)
                        """);

        int batchSize = 10000;

        for(long i=1;i<=10000000;i++) {

            ps.setString(1,faker.name().fullName());
            ps.setString(2,faker.internet().emailAddress());
            ps.setString(3,faker.phoneNumber().cellPhone());
            ps.setString(4,faker.address().city());
            ps.setDouble(5,4.0);

            ps.setDouble(
                    6,
                    17.3850 + Math.random());

            ps.setDouble(
                    7,
                    78.4867 + Math.random());

            ps.addBatch();

            if(i % batchSize == 0){

                ps.executeBatch();

                System.out.println(
                        "Inserted Riders : " + i);
            }
        }

        connection.close();
    }
}