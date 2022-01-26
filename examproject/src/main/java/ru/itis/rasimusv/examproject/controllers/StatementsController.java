package ru.itis.rasimusv.examproject.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.rasimusv.examproject.dto.PersonDto;
import ru.itis.rasimusv.examproject.services.StatementsService;

@RestController
public class StatementsController {

    private final StatementsService statementsService;

    public StatementsController(StatementsService statementsService) {
        this.statementsService = statementsService;
    }

    @PostMapping( "/youarethebest")
    public ResponseEntity<byte[]> youAreTheBest(@RequestBody PersonDto person) {
        byte[] data = statementsService.generateYouAreGreat(person);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

    @PostMapping( "/youarebad")
    @ResponseBody
    public ResponseEntity<byte[]> youAreBad(@RequestBody PersonDto person) {
        byte[] data = statementsService.generateYouBad(person);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
