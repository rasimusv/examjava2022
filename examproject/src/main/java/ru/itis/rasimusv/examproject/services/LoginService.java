package ru.itis.rasimusv.examproject.services;

import ru.itis.rasimusv.examproject.dto.CredentialsDto;
import ru.itis.rasimusv.examproject.dto.EmailPasswordDto;
import ru.itis.rasimusv.examproject.dto.RefreshTokenDto;

public interface LoginService {
    RefreshTokenDto login(EmailPasswordDto emailPassword);

    void signUp(CredentialsDto credentialsDto);
}
