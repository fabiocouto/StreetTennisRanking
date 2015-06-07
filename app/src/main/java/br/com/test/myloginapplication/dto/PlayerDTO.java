package br.com.test.myloginapplication.dto;

import android.graphics.Bitmap;
import android.media.Image;

import java.io.Serializable;

/**
 * Created by fabiodocoutooliveira on 05/06/15.
 */
public class PlayerDTO implements Serializable{

    private static final long serialVersionUID = 1L;

    private String playerName;
    private Integer gamesWon;
    public Integer icon;
    public String title;
    public Bitmap picture;


    public  PlayerDTO(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Bitmap getPicture() {
        return picture;
    }

    public void setPicture(Bitmap picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public PlayerDTO(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" +
                "playerName='" + playerName + '\'' +
                ", gamesWon=" + gamesWon +
                ", icon=" + icon +
                ", title='" + title + '\'' +
                ", picture=" + picture +
                '}';
    }
}
