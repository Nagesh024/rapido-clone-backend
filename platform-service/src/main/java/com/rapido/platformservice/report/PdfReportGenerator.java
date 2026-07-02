package com.rapido.platformservice.report;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class PdfReportGenerator {

    public void generate() throws Exception {

        Document document = new Document();

        PdfWriter.getInstance(
                document,
                new FileOutputStream("ExecutiveReport.pdf"));

        document.open();

        document.add(new Paragraph("Rapido Executive Report"));

        document.add(new Paragraph("Daily Operations Report"));

        document.add(new Paragraph("Weekly Executive Report"));

        document.add(new Paragraph("Monthly Business Review"));

        document.close();

    }

}