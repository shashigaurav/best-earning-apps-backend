package com.bestearningapps.service;
import com.bestearningapps.entity.TopGame;
import com.bestearningapps.repository.TopGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TopGameService {

    @Autowired
    private TopGameRepository repository;

    public TopGame addTopGame(TopGame game){
        return repository.save(game);
    }

    public List<TopGame> getTopGames(){
        return repository.findAll();
    }

}
