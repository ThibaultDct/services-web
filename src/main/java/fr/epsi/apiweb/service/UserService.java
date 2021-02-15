package fr.epsi.apiweb.service;

import fr.epsi.apiweb.resources.entities.GameEntity;
import fr.epsi.apiweb.resources.entities.UserEntity;
import fr.epsi.apiweb.resources.repositories.GamesRepository;
import fr.epsi.apiweb.resources.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    /* LOGGER */
    Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectConvertersService objectConvertersService;

    public UserEntity get(UUID id){
        UserEntity result = null;

        Optional<UserEntity> query = userRepository.findById(id);
        if (query.isPresent()){
            result = query.get();
        } else {
            LOGGER.error("Unable to get user with UUID {}", id);
        }

        return result;
    }

    public UserEntity getFromPseudo(String pseudo){
        UserEntity result = null;

        Optional<UserEntity> query = userRepository.findByUsername(pseudo);
        if (query.isPresent()){
            result = query.get();
        } else {
            LOGGER.error("Unable to get user with username {}", pseudo);
        }

        return result;
    }

}
