package com.luhpaglia.translucentapi.service;

import com.luhpaglia.translucentapi.dao.GameDAO;
import com.luhpaglia.translucentapi.enums.Console;
import com.luhpaglia.translucentapi.model.Game;
import com.luhpaglia.translucentapi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> selectAllGames() {

        return repository.findAll();
    }

    public void insertGame(GameDAO dao) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(dao.getDateCompletion());
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);

        Game newGame = new Game(dao.getTitle(),
                dao.getReleaseYear(),
                Console.valueOf(dao.getConsole()),
                dao.getCompleted().equals("YES")? true: false,
                calendarDate,
                dao.getPersonalNotes(),
                dao.getRate(),
                dao.getUrlImage());

        repository.save(newGame);
    }

    public void updateGame(GameDAO dao) {
    }

    public void deleteGame(Integer id) {
        repository.deleteById(id);
    }

    public Page<Game> selectGamesPageable(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size));
    }
}
