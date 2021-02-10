package fr.epsi.apiweb.service;

import fr.epsi.apiweb.resources.entities.GameEntity;
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
    private ObjectConvertersService objectConvertersService;

    public GameEntity create(GameEntity gameEntity){
        GameEntity result = null;
        GameEntity gameEntityToCreate = new GameEntity();
        UUID uuid = UUID.randomUUID();

        gameEntityToCreate.setGame_id(uuid);
        gameEntityToCreate.setName(gameEntity.getName());
        gameEntityToCreate.setIs_online(gameEntity.isIs_online());
        gameEntityToCreate.setDescription(gameEntity.getDescription());

        try {
            result = gamesRepository.save(gameEntityToCreate);
            LOGGER.info("Game {} created", gameEntityToCreate.getName());
        } catch (Exception e) {
            LOGGER.error("An error occured while creating game {} : {}", gameEntityToCreate.getName(), e.getMessage());
        }

        return result;
    }

    public GameEntity createFromDto(GameDTO dto){
        return create(objectConvertersService.gameDtoToEntity(dto));
    }

    public GameEntity get(UUID id){
        GameEntity result = null;

        Optional<GameEntity> query = gamesRepository.findById(id);
        if (query.isPresent()){
            result = query.get();
        } else {
            LOGGER.error("Unable to get game with UUID {}", id);
        }

        return result;
    }

    public List<GameEntity> getAll(){
        return gamesRepository.findAll();
    }

}
