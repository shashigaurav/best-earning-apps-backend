package com.bestearningapps.controller;

import com.bestearningapps.entity.Game;
import com.bestearningapps.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/games")
@CrossOrigin(origins = "*")   // 👈 ye add karna na bhoolein
public class GameController {

    @Autowired
    private GameService gameService;

    // ADD GAME
    @PostMapping
    public ResponseEntity<Map<String, Object>> addGame(@RequestBody Game game){
        Game savedGame = gameService.addGame(game);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "Game Added Successfully");
        res.put("data", savedGame);

        return ResponseEntity.ok(res);
    }

    // GET ALL GAMES
    @GetMapping
    public List<Game> getGames(){
        return gameService.getAllGames();
    }

    // UPDATE GAME
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateGame(@PathVariable Long id,
                                                          @RequestBody Game game){
        Game updatedGame = gameService.updateGame(id, game);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "Game Updated Successfully");
        res.put("data", updatedGame);

        return ResponseEntity.ok(res);
    }

    // DELETE GAME
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteGame(@PathVariable Long id){
        gameService.deleteGame(id);

        Map<String, Object> res = new HashMap<>();
        res.put("success", true);
        res.put("message", "Game Deleted Successfully");

        return ResponseEntity.ok(res);
    }
}