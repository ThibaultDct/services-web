package fr.epsi.apiweb.service;

import fr.epsi.apiweb.resources.dto.Game;
import fr.epsi.apiweb.resources.repositories.GamesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class GamesService {

    /* LOGGER */
    Logger LOGGER = LoggerFactory.getLogger(GamesService.class);

    @Autowired
    private GamesRepository gamesRepository;

    public void create(String name, boolean is_online, String description){
        Game gameToCreate = new Game();

        gameToCreate.setName(name);
        gameToCreate.setIs_online(is_online);
        gameToCreate.setDescription(description);

        try {
            gamesRepository.save(gameToCreate);
            LOGGER.info("Game {} created", gameToCreate.getName());
        } catch (Exception e) {
            LOGGER.error("An error occured while creating game {} : {}", gameToCreate.getName(), e.getMessage());
        }

    }

    public Game get(UUID id){
        Game result = null;

        Optional<Game> query = gamesRepository.findByGameId(id);
        if (query.isPresent()){
            result = query.get();
        } else {
            LOGGER.error("Unable to get game with UUID {}", id);
        }

        return result;
    }

}
