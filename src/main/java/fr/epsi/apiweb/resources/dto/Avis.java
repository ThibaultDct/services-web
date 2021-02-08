package fr.epsi.apiweb.resources.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Avis {

    @Id
    @Generated(GenerationTime.ALWAYS)
    private UUID avis_id;
    private String comment;
    private Integer like;
    private Integer dislike;

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
}
