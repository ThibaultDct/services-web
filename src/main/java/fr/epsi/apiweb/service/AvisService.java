package fr.epsi.apiweb.service;

import fr.epsi.apiweb.resources.dto.AvisDTO;
import fr.epsi.apiweb.resources.entities.AvisEntity;
import fr.epsi.apiweb.resources.repositories.AvisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AvisService {

    /* LOGGER */
    Logger LOGGER = LoggerFactory.getLogger(AvisService.class);

    @Autowired
    private AvisRepository avisRepository;

    @Autowired
    private ObjectConvertersService objectConvertersService;

    public AvisEntity create(AvisEntity avisEntity){
        AvisEntity result = null;
        AvisEntity avisEntityToCreate = new AvisEntity();
        UUID uuid = UUID.randomUUID();

        avisEntityToCreate.setAvis_id(uuid);
        avisEntityToCreate.setComment(avisEntity.getComment());
        avisEntityToCreate.setLike(avisEntity.getLike());
        avisEntityToCreate.setDislike(avisEntity.getDislike());
        avisEntityToCreate.setGame(avisEntity.getGame());
        avisEntityToCreate.setUser(avisEntity.getUser());

        try {
            result = avisRepository.save(avisEntityToCreate);
            LOGGER.info("Avis {} created", avisEntityToCreate.getAvis_id());
        } catch (Exception e) {
            LOGGER.error("An error occured while creating avis {} : {}", avisEntityToCreate.getAvis_id(), e.getMessage());
        }

        return result;
    }

    public AvisEntity createFromDto(AvisDTO dto, UUID game_id){
        return create(objectConvertersService.avisDtoToEntity(dto, game_id));
    }

    public AvisEntity get(UUID id){
        AvisEntity result = null;

        Optional<AvisEntity> query = avisRepository.findById(id);
        if (query.isPresent()){
            result = query.get();
        } else {
            LOGGER.error("Unable to get avis with UUID {}", id);
        }

        return result;
    }

    public List<AvisEntity> getAll(){
        return avisRepository.findAll();
    }

    public List<AvisEntity> getAvisByGame(UUID game_id){
        return avisRepository.findByGame(game_id);
    }

}
