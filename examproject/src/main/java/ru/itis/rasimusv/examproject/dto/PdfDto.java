package ru.itis.rasimusv.examproject.dto;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class PdfDto {
    private byte[] data;
}
