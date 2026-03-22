package com.bestearningapps.controller;

import com.bestearningapps.dto.LoginRequest;
import com.bestearningapps.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = {
        "http://localhost:4200",
        "https://best-earning-apps.netlify.app"
})
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {

        boolean valid = adminService.login(
                request.getUsername(),
                request.getPassword()
        );

        Map<String, Object> res = new HashMap<>();

        if (valid) {
            res.put("success", true);
        } else {
            res.put("success", false);
        }

        return res;
    }
}