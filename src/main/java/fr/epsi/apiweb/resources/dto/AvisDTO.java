package fr.epsi.apiweb.resources.dto;

import java.util.UUID;

public class AvisDTO {

    private String comment;
    private int like_score;
    private int dislike_score;
    private boolean is_positive;
    private UUID user_uuid;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getLike() {
        return like_score;
    }

    public void setLike(Integer like) {
        this.like_score = like;
    }

    public Integer getDislike() {
        return dislike_score;
    }

    public void setDislike(Integer dislike) {
        this.dislike_score = dislike;
    }

    public UUID getUser_uuid() {
        return user_uuid;
    }

    public void setUser_uuid(UUID user_uuid) {
        this.user_uuid = user_uuid;
    }

    public boolean isIs_positive() {
        return is_positive;
    }

    public void setIs_positive(boolean is_positive) {
        this.is_positive = is_positive;
    }
}
