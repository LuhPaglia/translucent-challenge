package com.luhpaglia.translucentapi.model;

import com.luhpaglia.translucentapi.enums.Console;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Getter @Setter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100)
    private String title;
    private Integer releaseYear;
    private Console console;
    private Boolean completed;
    private Calendar dateCompletion;
    @Column(length = 256)
    private String personalNotes;
    private Integer rate;
    @Column(length = 1000)
    private String urlImage;

    public Game(String title, Integer releaseYear, Console console, Boolean completed, Calendar dateCompletion, String personalNotes, Integer rate, String urlImage) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.console = console;
        this.completed = completed;
        this.dateCompletion = dateCompletion;
        this.personalNotes = personalNotes;
        this.rate = rate;
        this.urlImage = urlImage;
    }

    public Game(){}
}
