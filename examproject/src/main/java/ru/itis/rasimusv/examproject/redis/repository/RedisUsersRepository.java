package ru.itis.rasimusv.examproject.redis.repository;

import org.springframework.data.keyvalue.repository.KeyValueRepository;
import ru.itis.rasimusv.examproject.redis.models.RedisUser;

public interface RedisUsersRepository extends KeyValueRepository<RedisUser, String> {
}