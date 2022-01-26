package ru.itis.rasimusv.examproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rasimusv.examproject.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
