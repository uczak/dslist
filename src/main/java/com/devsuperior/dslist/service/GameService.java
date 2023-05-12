package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)//somente leitura, não bloqueia o banco para escrita.
    public List<GameMinDTO> findAll(){
        List<Game> list =  gameRepository.findAll();
        List<GameMinDTO> dto = list.stream().map(x-> new GameMinDTO(x)).toList();

        return dto;
    }

    @Transactional(readOnly = true)//somente leitura, não bloqueia o banco para escrita.
    public GameDTO findById(Long gameId){
        Game game =  gameRepository.findById(gameId).get();
        return new GameDTO(game);
    }
}
