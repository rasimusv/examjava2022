package ru.itis.rasimusv.examproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.rasimusv.examproject.models.Statement;

public interface StatementsRepository extends JpaRepository<Statement, Long> {
}

