package com.rapido.adminservice.config;

import com.rapido.adminservice.entity.Admin;
import com.rapido.adminservice.entity.AdminRole;
import com.rapido.adminservice.repository.AdminRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminDataLoader implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final PasswordEncoder passwordEncoder;

    public AdminDataLoader(AdminRepository adminRepository,
                           PasswordEncoder passwordEncoder) {
        this.adminRepository = adminRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (adminRepository.findByEmail("admin@rapido.com").isEmpty()) {

            Admin admin = new Admin();

            admin.setName("Super Admin");
            admin.setEmail("admin@rapido.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(AdminRole.SUPER_ADMIN);
            admin.setActive(true);

            adminRepository.save(admin);

            System.out.println("Admin Created Successfully");
        }
    }
}