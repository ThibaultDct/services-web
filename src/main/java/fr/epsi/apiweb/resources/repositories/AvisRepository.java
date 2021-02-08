package fr.epsi.apiweb.resources.repositories;

import fr.epsi.apiweb.resources.dto.Avis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AvisRepository extends JpaRepository<Avis, UUID> {
    Optional<Avis> findById(UUID id);
}
