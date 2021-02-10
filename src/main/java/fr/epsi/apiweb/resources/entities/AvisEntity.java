package fr.epsi.apiweb.resources.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "avis", schema = "public")
public class AvisEntity {

    @Id
    @Generated(GenerationTime.ALWAYS)
    private UUID avis_id;
    private String comment;
    private int like_score;
    private int dislike_score;
    @OneToOne
    @JoinColumn(name = "game", foreignKey = @ForeignKey(name = "FK_avis_game"))
    private GameEntity game;
    @OneToOne
    @JoinColumn(name = "profile", foreignKey = @ForeignKey(name = "FK_avis_profile"))
    private UserEntity profile;

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

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public UserEntity getUser() {
        return profile;
    }

    public void setUser(UserEntity user) {
        this.profile = user;
    }
}
