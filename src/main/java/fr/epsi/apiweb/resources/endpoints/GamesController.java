package fr.epsi.apiweb.resources.endpoints;

import fr.epsi.apiweb.business.Game;
import fr.epsi.apiweb.resources.entities.GameEntity;
import fr.epsi.apiweb.resources.dto.GameDTO;
import fr.epsi.apiweb.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class GamesController {

    @Autowired
    private GamesService gamesService;

    @GetMapping("/games/")
    public List<Game> retrieveAllGames(){
        return gamesService.getAll();
    }

    @GetMapping("/games/{id}")
    public GameEntity retrieveGameFromId(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        return gamesService.get(uuid);
    }

    @PostMapping(value = "/games", consumes = "application/json", produces = "application/json")
    public void addGame(@RequestBody GameDTO gameDTO){
        gamesService.createFromDto(gameDTO);
    }

}
