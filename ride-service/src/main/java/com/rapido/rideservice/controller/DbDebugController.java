package com.rapido.rideservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DbDebugController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/debug/db")
    public Map<String, Object> debugDb() {

        Map<String, Object> result = new HashMap<>();

        result.put("database", jdbcTemplate.queryForObject(
                "SELECT current_database()", String.class));

        result.put("schema", jdbcTemplate.queryForObject(
                "SELECT current_schema()", String.class));

        result.put("driverCount", jdbcTemplate.queryForObject(
                "SELECT COUNT(*) FROM drivers", Integer.class));

        return result;
    }
}