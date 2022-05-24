package com.luhpaglia.translucentapi.controller;

import com.luhpaglia.translucentapi.dao.GameDAO;
import com.luhpaglia.translucentapi.dao.GamePutDAO;
import com.luhpaglia.translucentapi.model.Game;
import com.luhpaglia.translucentapi.service.GameService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/catalog")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames(){
        return ResponseEntity.ok(service.selectAllGames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Integer id){
        return ResponseEntity.ok(service.selectById(id));
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<Page<Game>> getGamesPageable(@PathVariable Integer page, @PathVariable Integer size){
        return ResponseEntity.ok(service.selectGamesPageable(page, size));
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Game> postGame(@RequestBody GameDAO dao) throws ParseException {
        return ResponseEntity.ok(service.insertGame(dao));
    }

    @PutMapping
    public ResponseEntity<Game> putGame(@RequestBody GamePutDAO dao) throws ParseException {
        return ResponseEntity.ok(service.updateGame(dao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Game>> deleteGame(@PathVariable Integer id){
        service.deleteGame(id);
        return ResponseEntity.ok(service.selectAllGames());
    }

}
