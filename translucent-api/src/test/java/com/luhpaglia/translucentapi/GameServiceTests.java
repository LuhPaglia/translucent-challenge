package com.luhpaglia.translucentapi;

import com.luhpaglia.translucentapi.dao.GameDAO;
import com.luhpaglia.translucentapi.dao.GamePutDAO;
import com.luhpaglia.translucentapi.model.Game;
import com.luhpaglia.translucentapi.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.List;

@SpringBootTest
public class GameServiceTests {

    @Autowired
    GameService gameService;

    @Test
    public void insertGameTest() throws ParseException {
        GameDAO insert = new GameDAO("The last of us", "PS4", true, "2015-03-07", "", 4, 2015, "www.urlimg.com");
        Game gameInserted = gameService.insertGame(insert);
        Assertions.assertNotNull(gameInserted);
    }

    @Test
    public void selectGamesTest(){
        List<Game> listGames = gameService.selectAllGames();
        Assertions.assertTrue(listGames.size() > 0);
    }

    @Test
    public void updateGameTest() throws ParseException {
        GameDAO test1 = new GameDAO("Kingdom Herats", "PS4", true, "2018-05-04", "", 5, 2018, "www.urlimg.com");
        gameService.insertGame(test1);

        GamePutDAO update = new GamePutDAO(1, false, "2022-05-02", "", 5, "www.urlImg.com");
        Game game = gameService.updateGame(update);
        Assertions.assertTrue(!game.getCompleted());
    }

}
