package com.luhpaglia.translucentapi.controller;

import com.luhpaglia.translucentapi.dao.GameDAO;
import com.luhpaglia.translucentapi.model.Game;
import com.luhpaglia.translucentapi.service.GameService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<Game> getAllGames(){
        return service.selectAllGames();
    }

    @GetMapping("/{page}/{size}")
    public Page<Game> getGamesPageable(@PathVariable Integer page, @PathVariable Integer size){
        return service.selectGamesPageable(page, size);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Game> postGame(@RequestBody GameDAO dao) throws ParseException {
        service.insertGame(dao);
        return service.selectAllGames();
    }

    @PutMapping
    public List<Game> putGame(@RequestBody GameDAO dao){
        service.updateGame(dao);
        return service.selectAllGames();
    }

    @DeleteMapping("/{id}")
    public List<Game> putGame(@PathVariable Integer id){
        service.deleteGame(id);
        return service.selectAllGames();
    }

}
