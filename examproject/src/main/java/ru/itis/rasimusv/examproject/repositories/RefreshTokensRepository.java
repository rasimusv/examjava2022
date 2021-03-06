package ru.itis.rasimusv.examproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rasimusv.examproject.models.RefreshToken;

import java.util.Optional;

public interface RefreshTokensRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}
