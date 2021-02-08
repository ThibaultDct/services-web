package fr.epsi.apiweb.resources.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Game {

    @Id
    private UUID game_id;
    private String name;
    private boolean is_online;
    private String description;

}
