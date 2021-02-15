package fr.epsi.apiweb.resources.endpoints;

import fr.epsi.apiweb.business.Game;
import fr.epsi.apiweb.resources.entities.GameEntity;
import fr.epsi.apiweb.resources.dto.GameDTO;
import fr.epsi.apiweb.resources.entities.UserEntity;
import fr.epsi.apiweb.service.GamesService;
import fr.epsi.apiweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/fromPseudo/{pseudo}")
    public UserEntity retrieveFromPseudo(@PathVariable String pseudo){
        return userService.getFromPseudo(pseudo);
    }


}
