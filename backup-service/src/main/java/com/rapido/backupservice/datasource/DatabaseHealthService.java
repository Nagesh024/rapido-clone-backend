//package com.rapido.backupservice.datasource;
//
//import java.sql.Connection;
//
//import javax.sql.DataSource;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class DatabaseHealthService {
//
//    private final DataSource dataSource;
//
//    public DatabaseHealthService(
//            DataSource dataSource) {
//
//        this.dataSource = dataSource;
//    }
//
//    public boolean isDatabaseHealthy() {
//
//        try (Connection connection =
//                     dataSource.getConnection()) {
//
//            return connection.isValid(5);
//
//        } catch (Exception ex) {
//
//            return false;
//        }
//    }
//}