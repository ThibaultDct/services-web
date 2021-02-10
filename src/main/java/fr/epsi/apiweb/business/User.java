package fr.epsi.apiweb.business;

import java.util.UUID;

public class User {

    private UUID user_id;
    private String username;

    public User(UUID user_id, String username) {
        this.user_id = user_id;
        this.username = username;
    }

    public User(String username) {
        this.username = username;
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
