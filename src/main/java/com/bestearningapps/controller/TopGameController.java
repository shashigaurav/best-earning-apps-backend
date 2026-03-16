package com.bestearningapps.controller;

import com.bestearningapps.entity.TopGame;
import com.bestearningapps.service.TopGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/top-games")
public class TopGameController {

    @Autowired
    private TopGameService service;

    @PostMapping
    public TopGame addTopGame(@RequestBody TopGame game){
        return service.addTopGame(game);
    }

    @GetMapping
    public List<TopGame> getTopGames(){
        return service.getTopGames();
    }

}
