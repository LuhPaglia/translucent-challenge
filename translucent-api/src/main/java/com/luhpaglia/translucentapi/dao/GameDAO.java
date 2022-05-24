package com.luhpaglia.translucentapi.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.luhpaglia.translucentapi.enums.Console;
import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;


@Getter @Setter
public class GameDAO {
    private String title;
    private String console;
    private Boolean completed;
    private String dateCompletion;
    private String personalNotes;
    private Integer rate;
    private Integer releaseYear;
    private String urlImage;

    public GameDAO(){}

    public GameDAO(String title, String console, Boolean completed, String dateCompletion, String personalNotes, Integer rate, Integer releaseYear, String urlImage) {
        this.title = title;
        this.console = console;
        this.completed = completed;
        this.dateCompletion = dateCompletion;
        this.personalNotes = personalNotes;
        this.rate = rate;
        this.releaseYear = releaseYear;
        this.urlImage = urlImage;
    }
}

