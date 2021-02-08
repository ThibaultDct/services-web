package fr.epsi.apiweb.service;

import fr.epsi.apiweb.resources.dto.Game;
import fr.epsi.apiweb.resources.dto.GameDTO;
import fr.epsi.apiweb.resources.repositories.GamesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GamesService {

    /* LOGGER */
    Logger LOGGER = LoggerFactory.getLogger(GamesService.class);

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private DtoToEntity dtoToEntity;

    public Game create(Game game){
        Game result = null;
        Game gameToCreate = new Game();
        UUID uuid = UUID.randomUUID();

        gameToCreate.setGame_id(uuid);
        gameToCreate.setName(game.getName());
        gameToCreate.setIs_online(game.isIs_online());
        gameToCreate.setDescription(game.getDescription());

        try {
            result = gamesRepository.save(gameToCreate);
            LOGGER.info("Game {} created", gameToCreate.getName());
        } catch (Exception e) {
            LOGGER.error("An error occured while creating game {} : {}", gameToCreate.getName(), e.getMessage());
        }

        return result;
    }

    public Game createFromDto(GameDTO dto){
        return create(dtoToEntity.gameDtoToEntity(dto));
    }

    public Game get(UUID id){
        Game result = null;

        Optional<Game> query = gamesRepository.findById(id);
        if (query.isPresent()){
            result = query.get();
        } else {
            LOGGER.error("Unable to get game with UUID {}", id);
        }

        return result;
    }

    public List<Game> getAll(){
        return gamesRepository.findAll();
    }

}
