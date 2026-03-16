package com.bestearningapps.service;

import com.bestearningapps.entity.Banner;
import com.bestearningapps.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {

    @Autowired
    private BannerRepository repository;

    public Banner saveBanner(Banner banner){
        return repository.save(banner);
    }

    public Banner getBanner(){
        return repository.findAll().stream().findFirst().orElse(null);
    }

}
