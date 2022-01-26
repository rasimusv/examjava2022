package ru.itis.rasimusv.examproject.services;

import ru.itis.rasimusv.examproject.dto.AccessTokenDto;
import ru.itis.rasimusv.examproject.dto.RefreshTokenDto;

public interface TokensService {
    AccessTokenDto newToken(RefreshTokenDto refreshTokenDto);
    AccessTokenDto newToken(String refreshToken);
}
