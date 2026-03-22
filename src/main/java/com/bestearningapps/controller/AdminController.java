package com.bestearningapps.controller;

import com.bestearningapps.dto.LoginRequest;
import com.bestearningapps.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // TEST API (browser se check karne ke liye)
    @GetMapping("/test")
    public String test() {
        return "Backend API Working";
    }

    // LOGIN API
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {

        boolean valid = adminService.login(
                request.getUsername(),
                request.getPassword()
        );

        Map<String, Object> res = new HashMap<>();

        if(valid){
            res.put("success", true);
            res.put("message", "Login Successful");
        } else {
            res.put("success", false);
            res.put("message", "Invalid username or password");
        }

        return res;
    }


}
