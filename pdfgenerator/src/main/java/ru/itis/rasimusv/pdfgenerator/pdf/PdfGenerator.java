package ru.itis.rasimusv.pdfgenerator.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import ru.itis.rasimusv.pdfgenerator.dto.PdfDto;
import ru.itis.rasimusv.pdfgenerator.dto.PersonDto;

import java.io.ByteArrayOutputStream;

@Component
public class PdfGenerator {

    public static PdfDto generateYouAreGreatForm(PersonDto person) {
        return generateImageAndTextForm(person, "great.jpg", BaseColor.PINK);
    }

    public static PdfDto generateYouAreBadForm(PersonDto person) {
        return generateImageAndTextForm(person, "loser.jpg", BaseColor.BLACK);
    }

    private static PdfDto generateImageAndTextForm(PersonDto person, String imageFileName, BaseColor color) {
        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            var name = person.getFirstName() + " " + person.getLastName();
            Font font = FontFactory.getFont(FontFactory.COURIER, 25, color);
            Chunk chunk = new Chunk(name, font);

            PdfWriter.getInstance(document, out);
            document.open();
            Image img = Image.getInstance(ResourceUtils.getURL("classpath:images/" + imageFileName));
            img.scaleAbsolute(PageSize.A4.rotate());
            img.setAbsolutePosition(0, 0);
            document.add(img);
            document.add(chunk);

            document.close();

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

        return PdfDto.builder().data(out.toByteArray()).build();
    }
}
