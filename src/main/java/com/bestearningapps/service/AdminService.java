package com.bestearningapps.service;

import com.bestearningapps.entity.Admin;
import com.bestearningapps.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean login(String username, String password) {

        // 🔥 1. DEFAULT ADMIN (fallback for testing)
        if(username.equals("admin") && password.equals("Earn@121")){
            return true;
        }

        // 🔥 2. DATABASE CHECK
        Optional<Admin> admin = adminRepository.findByUsername(username);

        if(admin.isPresent()){
            return admin.get().getPassword().equals(password);
        }

        return false;
    }
}