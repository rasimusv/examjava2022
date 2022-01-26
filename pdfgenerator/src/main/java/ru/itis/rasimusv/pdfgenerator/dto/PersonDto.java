package ru.itis.rasimusv.pdfgenerator.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class PersonDto {
    private String firstName;
    private String lastName;
}
