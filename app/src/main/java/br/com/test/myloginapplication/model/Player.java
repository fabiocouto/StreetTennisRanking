package br.com.test.myloginapplication.model;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by fabiodocoutooliveira on 24/05/15.
 */
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer ID;
    private String name;
    private Integer gamesWon;
    private Image picture;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }


    public Integer getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(Integer gamesWon) {
        this.gamesWon = gamesWon;
    }

    public Image getPicture() {
        return picture;
    }

    public void setPicture(Image picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;

        Player player = (Player) o;

        if (ID != null ? !ID.equals(player.ID) : player.ID != null) return false;
        if (getName() != null ? !getName().equals(player.getName()) : player.getName() != null)
            return false;
        if (getGamesWon() != null ? !getGamesWon().equals(player.getGamesWon()) : player.getGamesWon() != null)
            return false;
        return !(getPicture() != null ? !getPicture().equals(player.getPicture()) : player.getPicture() != null);

    }

    @Override
    public int hashCode() {
        int result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getGamesWon() != null ? getGamesWon().hashCode() : 0);
        result = 31 * result + (getPicture() != null ? getPicture().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Player{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", gamesWon=" + gamesWon +
                ", picture=" + picture +
                '}';
    }
}
