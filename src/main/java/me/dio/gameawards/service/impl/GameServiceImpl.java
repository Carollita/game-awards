package me.dio.gameawards.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.gameawards.domain.model.Game;
import me.dio.gameawards.domain.model.GameRepository;
import me.dio.gameawards.service.GameService;
import me.dio.gameawards.service.exception.BusinessException;
import me.dio.gameawards.service.exception.NoContentException;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    private GameRepository repository;

    @Override
    public List<Game> findAll() {
        List<Game> games = repository.findAll();
        return games;
    }

    @Override
    public Game findId(Long id) {
        Optional<Game> game = repository.findById(id);
        return game.orElseThrow(() -> new NoContentException());
        /*if(game.isPresent()) {
            return game.get();
        } else {
            throw new NoContentException;
        }*/
    }

    @Override
    public void insert(Game game) {
        repository.save(game);
        
    }

    @Override
    public void update(Long id, Game game) {
        Game gameDatabase = findId(id);
        if(gameDatabase.getId().equals(game.getId())) {
            repository.save(game);
        } else {
            throw new BusinessException("erro");
        }
        
    }

    @Override
    public void delete(Long id) {
        Game gameDatabase = findId(id);
        repository.delete(gameDatabase);
        
    }
    
}
