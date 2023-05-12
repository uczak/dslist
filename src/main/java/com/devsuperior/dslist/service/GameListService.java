package com.devsuperior.dslist.service;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repository.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)//somente leitura, não bloqueia o banco para escrita.
    public List<GameListDTO> findAll(){
        List<GameList> list =  gameListRepository.findAll();
        List<GameListDTO> dto = list.stream().map(x-> new GameListDTO(x)).toList();
        return dto;
    }

}
