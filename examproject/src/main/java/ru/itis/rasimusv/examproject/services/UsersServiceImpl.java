package ru.itis.rasimusv.examproject.services;

import org.springframework.stereotype.Service;
import ru.itis.rasimusv.examproject.models.User;
import ru.itis.rasimusv.examproject.redis.services.RedisUsersService;
import ru.itis.rasimusv.examproject.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final RedisUsersService redisUsersService;

    public UsersServiceImpl(UsersRepository usersRepository, RedisUsersService redisUsersService) {
        this.usersRepository = usersRepository;
        this.redisUsersService = redisUsersService;
    }

    @Override
    public void blockUser(Long userId) {
        User user = usersRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        redisUsersService.addAllTokensToBlackList(user);
    }
}