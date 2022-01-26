package ru.itis.rasimusv.pdfgenerator.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.itis.rasimusv.pdfgenerator.config.RabbitConfig;
import ru.itis.rasimusv.pdfgenerator.dto.PersonDto;
import ru.itis.rasimusv.pdfgenerator.pdf.PdfGenerator;


@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final ObjectMapper objectMapper;

    public ConsumerServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    @RabbitListener(queues = RabbitConfig.GREAT_QUEUE)
    public String receiveAndReturnGreatPdf(PersonDto person) throws JsonProcessingException {
        return objectMapper.writeValueAsString(PdfGenerator.generateYouAreGreatForm(person));
    }

    @Override
    @RabbitListener(queues = RabbitConfig.BAD_QUEUE)
    public String receiveAndReturnBadPdf(PersonDto person) throws JsonProcessingException {
        return objectMapper.writeValueAsString(PdfGenerator.generateYouAreBadForm(person));
    }
}
