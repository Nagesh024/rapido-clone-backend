//package com.rapido.backupservice.datasource;
//
//import javax.sql.DataSource;
//
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class DataSourceConfig {
//
//    @Bean
//    public DataSource dataSource() {
//
//        return DataSourceBuilder.create()
//                .driverClassName(
//                        "org.postgresql.Driver")
//                .url(
//                        "jdbc:postgresql://localhost:5432,localhost:5433/rapidodb?targetServerType=primary")
//                .username("postgres")
//                .password("postgres")
//                .build();
//    }
//}