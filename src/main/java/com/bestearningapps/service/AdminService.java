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

        // fallback admin (test login)
        if ("admin".equals(username) && "Earn@121".equals(password)) {
            return true;
        }

        try {
            Optional<Admin> admin = adminRepository.findByUsername(username);

            if (admin.isPresent()) {
                return password.equals(admin.get().getPassword());
            }

        } catch (Exception e) {
            e.printStackTrace();   // error Render logs me dikhega
        }

        return false;
    }
}