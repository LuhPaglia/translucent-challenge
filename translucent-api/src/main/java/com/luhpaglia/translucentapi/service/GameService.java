package com.luhpaglia.translucentapi.service;

import com.luhpaglia.translucentapi.dao.GameDAO;
import com.luhpaglia.translucentapi.dao.GamePutDAO;
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
import java.util.*;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<Game> selectAllGames() {
        return repository.findAllByOrderByReleaseYearDesc();
    }

    public Game selectById(Integer id){
        return repository.getById(id);
    }

    public Game insertGame(GameDAO dao) throws ParseException {
        Calendar calendarDate = Calendar.getInstance();

        if(dao.getCompleted()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dao.getDateCompletion());
            calendarDate.setTime(date);
        }else{
            calendarDate = null;
        }

        Game newGame = new Game(dao.getTitle(),
                dao.getReleaseYear(),
                Console.valueOf(dao.getConsole()),
                dao.getCompleted(),
                calendarDate,
                dao.getPersonalNotes(),
                dao.getRate(),
                dao.getUrlImage());

        return repository.save(newGame);
    }

    public Game updateGame(GamePutDAO dao) throws ParseException {
        Game game = repository.findById(dao.getId()).get();

        Calendar calendarDate = Calendar.getInstance();
        if(dao.getCompleted()){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dao.getDateCompletion());
            calendarDate.setTime(date);
        }else{
            calendarDate = null;
        }

        game.setCompleted(dao.getCompleted());
        game.setDateCompletion(calendarDate);
        game.setPersonalNotes(dao.getPersonalNotes());
        game.setUrlImage(dao.getUrlImage());
        return repository.save(game);
    }

    public void deleteGame(Integer id) {
        repository.deleteById(id);
    }

    public Page<Game> selectGamesPageable(Integer page, Integer size) {
        return repository.findAll(PageRequest.of(page, size));
    }

    public void createDataBase(){
        List<GameDAO> dataBase =  new ArrayList<>();

        dataBase.add(new GameDAO("KINGDOM HEARTS III", "PS4", true, "2018-05-12",
                "KINGDOM HEARTS III tells the story of the power of friendship as Sora and his friends embark on a perilous adventure. Set in a vast array of Disney and Pixar worlds, KINGDOM HEARTS follows the journey of Sora."
                , 5, 2018, "https://meups.com.br/wp-content/uploads/2018/12/Kingdom-Hearts-3-2.jpg"));

        dataBase.add(new GameDAO("Grand Theft Auto V", "PS4", true, "2015-09-22",
                "The game is played from either a third-person or first-person perspective, and its world is navigated on foot and by vehicle. Players control the three lead protagonists throughout single-player and switch among them, both during and outside missions."
                , 5, 2012, "https://s2.glbimg.com/nPM4vjS6i8lK_tLDny0F_-NwA2c=/0x0:695x390/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/2/5/ETbwT9TsCx1HJiImc26g/2014-02-13-jogo.jpg"));

        dataBase.add(new GameDAO("Bayonetta 2", "SWITCH", true, "2019-10-04",
                "Bayonetta 2 carries on the action-style gameplay of its predecessor, in which players control the eponymous Bayonetta as she fights against various angelic and demonic forces using combinations of melee attacks and gunplay. "
                , 5, 2019, "https://s2.glbimg.com/f1vkrvMUvKoIws5QA5LwBXuDwA0=/0x0:695x434/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/Z/9/kAxiAdSgmB62mOi4377A/2014-10-29-url.jpg"));

        dataBase.add(new GameDAO("Halo 5: Guardians", "XBOXONE", true, "2015-12-23",
"Halo 5: Guardians is a first-person shooter, with players experiencing most gameplay through the eyes of a playable character. The camera switches to a third-person view for some cinematics and gameplay sequences."
                , 5, 2015, "https://s2.glbimg.com/i2LjtBdRalCB4mrVqthlQjeLbFA=/0x0:695x391/984x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_08fbf48bc0524877943fe86e43087e7a/internal_photos/bs/2021/c/B/2m1RjxRcAGbTxXiao1Jw/2015-10-26-haloart.jpg"));

        dataBase.add(new GameDAO("The Last of Us Part II", "PS5", true, "2021-08-15",
"he Last of Us Part II is an action-adventure game played from a third-person perspective featuring elements of the survival horror genre.[1][2] The player traverses post-apocalyptic environments such as buildings and forests to advance the story. "
                , 5, 2020, "https://rollingstone.uol.com.br/media/_versions/the-last-of-us-part-2-reprod-nautghy-dog_widelg.jpg"));

        dataBase.forEach(game -> {
            try {
                this.insertGame(game);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }
}
