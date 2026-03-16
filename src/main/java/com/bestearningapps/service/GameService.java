package com.bestearningapps.service;

import com.bestearningapps.entity.Game;
import com.bestearningapps.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;   // ✅ Missing import

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public Game addGame(Game game){
        return repository.save(game);
    }

    public List<Game> getAllGames(){
        return repository.findAll();
    }

    public Game updateGame(Long id, Game updatedGame){

        Optional<Game> existingGame = repository.findById(id);

        if(existingGame.isPresent()){

            Game game = existingGame.get();

            game.setAppName(updatedGame.getAppName());
            game.setGameTitle(updatedGame.getGameTitle());
            game.setBonus(updatedGame.getBonus());
            game.setImage(updatedGame.getImage());
            game.setKeywords(updatedGame.getKeywords());
            game.setDownloadLink(updatedGame.getDownloadLink());
            game.setCategory(updatedGame.getCategory());

            return repository.save(game);
        }

        return null;
    }
    public void deleteGame(Long id){
        repository.deleteById(id);
    }
}