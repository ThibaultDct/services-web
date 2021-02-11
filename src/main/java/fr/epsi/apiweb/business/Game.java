package fr.epsi.apiweb.business;

import java.io.Serializable;
import java.util.UUID;

public class Game implements Serializable {

    private UUID game_id;
    private String name;
    private boolean is_online;
    private String description;
    private int score;

    public Game(UUID game_id, String name, boolean is_online, String description) {
        this.game_id = game_id;
        this.name = name;
        this.is_online = is_online;
        this.description = description;
    }

    public Game(String name, boolean is_online, String description) {
        this.game_id = UUID.randomUUID();
        this.name = name;
        this.is_online = is_online;
        this.description = description;
    }

    public UUID getGame_id() {
        return game_id;
    }

    public void setGame_id(UUID game_id) {
        this.game_id = game_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_online() {
        return is_online;
    }

    public void setIs_online(boolean is_online) {
        this.is_online = is_online;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
