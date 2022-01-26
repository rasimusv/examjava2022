package ru.itis.rasimusv.pdfgenerator.services;

import ru.itis.rasimusv.pdfgenerator.dto.PersonDto;

public interface ConsumerService {

    String receiveAndReturnGreatPdf(PersonDto person) throws Exception;

    String receiveAndReturnBadPdf(PersonDto person) throws Exception;
}
