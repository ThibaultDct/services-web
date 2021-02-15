package fr.epsi.apiweb.resources.repositories;

import fr.epsi.apiweb.resources.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;
import java.util.Optional;
import java.util.UUID;

@Repository
@Table(name = "user_auth")
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findById(UUID id);
    Optional<UserEntity> findByUsername(String username);
}