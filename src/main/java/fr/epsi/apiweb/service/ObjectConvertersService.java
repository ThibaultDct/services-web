package fr.epsi.apiweb.service;

import fr.epsi.apiweb.business.Avis;
import fr.epsi.apiweb.business.Game;
import fr.epsi.apiweb.business.User;
import fr.epsi.apiweb.resources.dto.AvisDTO;
import fr.epsi.apiweb.resources.entities.AvisEntity;
import fr.epsi.apiweb.resources.entities.GameEntity;
import fr.epsi.apiweb.resources.dto.GameDTO;
import fr.epsi.apiweb.resources.entities.UserEntity;
import fr.epsi.apiweb.resources.repositories.GamesRepository;
import fr.epsi.apiweb.resources.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ObjectConvertersService {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GamesService gamesService;

    @Autowired
    private UserService userService;

    public GameEntity gameDtoToEntity(GameDTO dto){
        GameEntity result = new GameEntity();

        result.setName(dto.getName());
        result.setIs_online(dto.isIs_online());
        result.setDescription(dto.getDescription());

        return result;
    }

    public AvisEntity avisDtoToEntity(AvisDTO dto, UUID game_id){
        AvisEntity result = new AvisEntity();

        result.setComment(dto.getComment());
        result.setLike(dto.getLike());
        result.setDislike(dto.getDislike());
        result.setGame(gamesService.get(game_id));
        result.setUser(userService.get(dto.getUser_uuid()));

        return result;
    }

    public Game gameEntityToGame(GameEntity gameEntity){
        return new Game(gameEntity.getGame_id(), gameEntity.getName(), gameEntity.isIs_online(), gameEntity.getDescription());
    }

    public GameEntity gameToGameEntity(Game game){
        GameEntity result = new GameEntity();

        result.setGame_id(game.getGame_id());
        result.setName(game.getName());
        result.setIs_online(game.isIs_online());
        result.setDescription(game.getDescription());

        return result;
    }

    public User userEntityToUser(UserEntity userEntity){
        return new User(userEntity.getUser_id(), userEntity.getUsername());
    }

    public UserEntity userToUserEntity(User user){
        UserEntity result = new UserEntity();

        result.setUser_id(user.getUser_id());
        result.setUsername(user.getUsername());

        return result;
    }

    public Avis avisEntityToAvis(AvisEntity avisEntity){
        return new Avis(avisEntity.getAvis_id(), avisEntity.getComment(), avisEntity.getLike(), avisEntity.getDislike(), gameEntityToGame(avisEntity.getGame()), userEntityToUser(avisEntity.getUser()));
    }

    public AvisEntity avisToAvisEntity(Avis avis){
        AvisEntity result = new AvisEntity();

        result.setAvis_id(avis.getAvis_id());
        result.setComment(avis.getComment());
        result.setLike(avis.getLike());
        result.setDislike(avis.getDislike());
        result.setGame(gameToGameEntity(avis.getGame()));
        result.setUser(userToUserEntity(avis.getUser()));

        return result;
    }

}
