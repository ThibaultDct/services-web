package fr.epsi.apiweb.resources.entities;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "game")
public class GameEntity {

    @Id
    @Generated(GenerationTime.ALWAYS)
    private UUID game_id;
    private String name;
    private boolean is_online;
    private String description;

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
}
