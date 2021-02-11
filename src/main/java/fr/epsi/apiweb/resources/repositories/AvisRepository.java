package fr.epsi.apiweb.resources.repositories;

import fr.epsi.apiweb.resources.entities.AvisEntity;
import fr.epsi.apiweb.resources.entities.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AvisRepository extends JpaRepository<AvisEntity, UUID> {
    Optional<AvisEntity> findById(UUID id);
    List<AvisEntity> findAll();
    List<AvisEntity> findByGame(GameEntity game);
}
