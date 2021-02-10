package fr.epsi.apiweb.business;

import java.util.UUID;

public class Avis {

    private UUID avis_id;
    private String comment;
    private Integer like;
    private Integer dislike;
    private Game game;
    private User user;

    public Avis(UUID avis_id, String comment, Integer like, Integer dislike, Game game, User user) {
        this.avis_id = avis_id;
        this.comment = comment;
        this.like = like;
        this.dislike = dislike;
        this.game = game;
        this.user = user;
    }

    public Avis(String comment, Integer like, Integer dislike, Game game, User user) {
        this.avis_id = UUID.randomUUID();
        this.comment = comment;
        this.like = like;
        this.dislike = dislike;
        this.game = game;
        this.user = user;
    }

    public UUID getAvis_id() {
        return avis_id;
    }

    public void setAvis_id(UUID avis_id) {
        this.avis_id = avis_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDislike() {
        return dislike;
    }

    public void setDislike(Integer dislike) {
        this.dislike = dislike;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
