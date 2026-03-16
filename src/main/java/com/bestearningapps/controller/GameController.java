package com.bestearningapps.controller;

import com.bestearningapps.entity.Game;
import com.bestearningapps.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public Game addGame(@RequestBody Game game){
        return gameService.addGame(game);
    }

    @GetMapping
    public List<Game> getGames(){
        return gameService.getAllGames();
    }
    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id,
                           @RequestBody Game game){

        return gameService.updateGame(id, game);
    }
    @DeleteMapping("/{id}")
    public String deleteGame(@PathVariable Long id){

        gameService.deleteGame(id);

        return "Game Deleted Successfully";
    }

}