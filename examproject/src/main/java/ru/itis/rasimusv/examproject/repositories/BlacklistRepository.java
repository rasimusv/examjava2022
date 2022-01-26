package ru.itis.rasimusv.examproject.repositories;

public interface BlacklistRepository {
    void save(String token);

    boolean exists(String token);
}