package ru.itis.rasimusv.examproject.services;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ru.itis.rasimusv.examproject.dto.PdfDto;
import ru.itis.rasimusv.examproject.dto.PersonDto;
import ru.itis.rasimusv.examproject.models.Statement;
import ru.itis.rasimusv.examproject.config.RabbitConfig;
import ru.itis.rasimusv.examproject.repositories.StatementsRepository;

@Service
public class StatementsServiceImpl implements StatementsService {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;
    private final StatementsRepository statementsRepository;
    private final DirectExchange directExchange;

    public StatementsServiceImpl(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper, StatementsRepository statementsRepository, DirectExchange directExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
        this.statementsRepository = statementsRepository;
        this.directExchange = directExchange;
    }

    @Override
    public void save(PersonDto person, Statement.Type type) {
        Statement statement = Statement.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .type(type)
                .build();

        statementsRepository.save(statement);
    }

    @Override
    public byte[] generateYouAreGreat(PersonDto person) {
        try {
            PdfDto pdf = objectMapper.readValue((String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), RabbitConfig.GREAT_QUEUE, person), PdfDto.class);
            if (pdf == null) {throw new IllegalArgumentException();}
            save(person, Statement.Type.GREAT);
            return pdf.getData();
        } catch (JacksonException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public byte[] generateYouBad(PersonDto person) {
        try {
            PdfDto pdf = objectMapper.readValue((String) rabbitTemplate.convertSendAndReceive(directExchange.getName(), RabbitConfig.BAD_QUEUE, person), PdfDto.class);
            if (pdf == null) {throw new IllegalArgumentException();}
            save(person, Statement.Type.BAD);
            return pdf.getData();
        } catch (JacksonException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
