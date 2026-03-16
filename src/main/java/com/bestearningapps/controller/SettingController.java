package com.bestearningapps.controller;

import com.bestearningapps.entity.Setting;
import com.bestearningapps.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/settings")
public class SettingController {

    @Autowired
    private SettingService service;

    @PostMapping
    public Setting saveSetting(@RequestBody Setting setting){
        return service.save(setting);
    }

    @GetMapping
    public Setting getSetting(){
        return service.getSetting();
    }

}
