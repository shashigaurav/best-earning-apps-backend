package com.bestearningapps.service;

import com.bestearningapps.entity.Setting;
import com.bestearningapps.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingService {

    @Autowired
    private SettingRepository repository;

    public Setting save(Setting setting){
        return repository.save(setting);
    }

    public Setting getSetting(){
        return repository.findAll().stream().findFirst().orElse(null);
    }

}
