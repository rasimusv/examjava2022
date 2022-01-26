package ru.itis.rasimusv.pdfgenerator.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class PdfDto {
    private byte[] data;
}
