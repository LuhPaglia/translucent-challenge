package com.luhpaglia.translucentapi.dao;

import com.luhpaglia.translucentapi.enums.Console;
import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;


@Getter @Setter
public class GameDAO {
    private String title;
    private String console;
    private String completed;
    private String dateCompletion;
    private String personalNotes;
    private Integer rate;
    private Integer releaseYear;
    private String urlImage;
}

