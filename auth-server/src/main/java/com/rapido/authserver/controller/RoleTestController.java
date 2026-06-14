package com.rapido.authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleTestController {

    @GetMapping("/api/user/profile")
    public String userProfile() {
        return "User Profile Access Granted";
    }

    @GetMapping("/api/driver/rides")
    public String driverRides() {
        return "Driver Ride Access Granted";
    }

    @GetMapping("/api/admin/dashboard")
    public String adminDashboard() {
        return "Admin Dashboard Access Granted";
    }
}