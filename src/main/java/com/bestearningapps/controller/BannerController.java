package com.bestearningapps.controller;

import com.bestearningapps.entity.Banner;
import com.bestearningapps.service.BannerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/banner")
@CrossOrigin(origins = "http://localhost:4200")
public class BannerController {

    @Autowired
    private BannerService service;

    /* GET BANNER */

    @GetMapping
    public Banner getBanner(){
        return service.getBanner();
    }

    /* UPDATE BANNER */

    @PutMapping
    public Banner updateBanner(@RequestBody Banner banner){
        return service.saveBanner(banner);
    }

}