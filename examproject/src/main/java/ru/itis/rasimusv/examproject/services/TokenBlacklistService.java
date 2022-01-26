package ru.itis.rasimusv.examproject.services;

public interface TokenBlacklistService {
    void add(String token);

    boolean exists(String token);
}