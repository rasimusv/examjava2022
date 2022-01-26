package ru.itis.rasimusv.examproject.services;

import org.springframework.stereotype.Service;
import ru.itis.rasimusv.examproject.repositories.BlacklistRepository;

@Service
public class TokenBlacklistServiceImpl implements TokenBlacklistService {

    private final BlacklistRepository blacklistRepository;

    public TokenBlacklistServiceImpl(BlacklistRepository blacklistRepository) {
        this.blacklistRepository = blacklistRepository;
    }

    @Override
    public void add(String token) {
        blacklistRepository.save(token);
    }

    @Override
    public boolean exists(String token) {
        return blacklistRepository.exists(token);
    }
}