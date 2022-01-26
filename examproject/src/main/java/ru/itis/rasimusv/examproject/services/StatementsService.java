package ru.itis.rasimusv.examproject.services;

import ru.itis.rasimusv.examproject.dto.PersonDto;
import ru.itis.rasimusv.examproject.models.Statement;

public interface StatementsService {
    void save(PersonDto person, Statement.Type type);

    byte[] generateYouAreGreat(PersonDto person);
    byte[] generateYouBad(PersonDto person);
}
