package fr.epsi.apiweb.resources.repositories;

import fr.epsi.apiweb.resources.dto.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Table(name = "games")
public interface GamesRepository extends JpaRepository<Game, UUID> {
    List<Game> findAll();
    Optional<Game> findByName(String name);
}
