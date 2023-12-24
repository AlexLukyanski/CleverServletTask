package by.clever.servlet.service.impl;

import by.clever.servlet.dto.MusicBandDTO;
import by.clever.servlet.service.exception.PrintServiceException;
import by.clever.servlet.service.validation.PrintMusicBandToPDFService;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class PrintTitleMusicBandToPDFServiceImpl implements PrintMusicBandToPDFService {

    @Override
    public void printMusicBandToPDF(MusicBandDTO musicBandDTO) {

        String fileName = "Clevertec_Template.pdf";
        String outputFileName = "Clevertec_Band_With_Title.pdf";
        String stringToPrint = "Title";

        try (PdfReader reader = new PdfReader(fileName);
             PdfWriter writer = new PdfWriter(outputFileName);
             PdfDocument pdfDocument = new PdfDocument(reader, writer);
             Document document = new Document(pdfDocument)) {

            Paragraph paragraph = new Paragraph(stringToPrint);
            paragraph.setFixedPosition(300, 600, 100);
            document.add(paragraph);

        } catch (IOException e) {
            throw new PrintServiceException(e);
        }
    }
}
