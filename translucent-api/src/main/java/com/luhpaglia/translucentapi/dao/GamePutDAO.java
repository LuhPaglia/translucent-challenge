package com.luhpaglia.translucentapi.dao;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GamePutDAO {
    private Integer id;
    private Boolean completed;
    private String dateCompletion;
    private String personalNotes;
    private Integer rate;
    private String urlImage;

    public GamePutDAO(){}

    public GamePutDAO(Integer id, Boolean completed, String dateCompletion, String personalNotes, Integer rate, String urlImage) {
        this.id = id;
        this.completed = completed;
        this.dateCompletion = dateCompletion;
        this.personalNotes = personalNotes;
        this.rate = rate;
        this.urlImage = urlImage;
    }
}
