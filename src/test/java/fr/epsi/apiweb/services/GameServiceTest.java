package fr.epsi.apiweb.services;

import fr.epsi.apiweb.resources.dto.Game;
import fr.epsi.apiweb.resources.repositories.GamesRepository;
import fr.epsi.apiweb.service.GamesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@PropertySource("h2-database.properties")
public class GameServiceTest {

    @Autowired
    private GamesRepository gamesRepository;

    @Autowired
    private GamesService gamesService;

    @Test
    public void testCreateNewGame(){
        Game test = new Game();
        test.setName("Minecraft");
        test.setDescription("Block game");
        test.setIs_online(true);

        Game game = gamesService.create(test);

        assertThat(gamesRepository.findByName("Minecraft").get().getGame_id().equals(game.getGame_id()));
    }

}
