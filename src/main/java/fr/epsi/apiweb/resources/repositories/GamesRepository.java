package fr.epsi.apiweb.resources.repositories;

import fr.epsi.apiweb.resources.dto.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GamesRepository extends JpaRepository<Game, UUID> {
    Optional<Game> findByGameId(UUID id);
}
