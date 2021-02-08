package fr.epsi.apiweb.service;

import fr.epsi.apiweb.resources.dto.Game;
import fr.epsi.apiweb.resources.dto.GameDTO;
import org.springframework.stereotype.Service;

@Service
public class DtoToEntity {

    public Game gameDtoToEntity(GameDTO dto){
        Game result = new Game();

        result.setName(dto.getName());
        result.setIs_online(dto.isIs_online());
        result.setDescription(dto.getDescription());

        return result;
    }

}
