package ru.itis.rasimusv.examproject.redis.services;

import ru.itis.rasimusv.examproject.models.User;

public interface RedisUsersService {
    void addTokenToUser(User user, String token);

    void addAllTokensToBlackList(User user);
}