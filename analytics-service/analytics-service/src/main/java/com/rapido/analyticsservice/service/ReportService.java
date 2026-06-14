package com.rapido.analyticsservice.service;

import com.rapido.analyticsservice.repository.FactRideRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

@Service
public class ReportService {

    private final FactRideRepository factRideRepository;

    public ReportService(
            FactRideRepository factRideRepository) {

        this.factRideRepository = factRideRepository;
    }

    public String generateCsvReport() {

        String fileName = "analytics-report.csv";

        try (FileWriter writer =
                     new FileWriter(fileName)) {

            writer.append("Metric,Value\n");

            writer.append("Total Rides,")
                    .append(String.valueOf(
                            factRideRepository.count()))
                    .append("\n");

            BigDecimal revenue =
                    factRideRepository
                            .getTotalRevenue();

            writer.append("Revenue,")
                    .append(String.valueOf(revenue))
                    .append("\n");

            Long completed =
                    factRideRepository
                            .countByStatus("COMPLETED");

            writer.append("Completed Rides,")
                    .append(String.valueOf(completed))
                    .append("\n");

        } catch (IOException e) {

            throw new RuntimeException(
                    "CSV Generation Failed",
                    e);
        }

        return fileName;
    }

    public String generateExcelReport() {

        String fileName = "analytics-report.xlsx";

        try (XSSFWorkbook workbook =
                     new XSSFWorkbook()) {

            Sheet sheet =
                    workbook.createSheet(
                            "Analytics Report");

            Row header =
                    sheet.createRow(0);

            header.createCell(0)
                    .setCellValue("Metric");

            header.createCell(1)
                    .setCellValue("Value");

            Row row1 =
                    sheet.createRow(1);

            row1.createCell(0)
                    .setCellValue("Total Rides");

            row1.createCell(1)
                    .setCellValue(
                            factRideRepository.count());

            Row row2 =
                    sheet.createRow(2);

            row2.createCell(0)
                    .setCellValue("Revenue");

            row2.createCell(1)
                    .setCellValue(
                            factRideRepository
                                    .getTotalRevenue()
                                    .doubleValue());

            Row row3 =
                    sheet.createRow(3);

            row3.createCell(0)
                    .setCellValue(
                            "Completed Rides");

            row3.createCell(1)
                    .setCellValue(
                            factRideRepository
                                    .countByStatus(
                                            "COMPLETED"));

            try (FileOutputStream out =
                         new FileOutputStream(
                                 fileName)) {

                workbook.write(out);
            }

        } catch (Exception e) {

            throw new RuntimeException(
                    "Excel Generation Failed",
                    e);
        }

        return fileName;
    }

    public String generatePdfReport() {

        String fileName = "analytics-report.pdf";

        try {

            Document document =
                    new Document();

            PdfWriter.getInstance(
                    document,
                    new FileOutputStream(
                            fileName));

            document.open();

            document.add(
                    new Paragraph(
                            "RAPIDO ANALYTICS REPORT"));

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Total Rides: "
                                    + factRideRepository.count()));

            document.add(
                    new Paragraph(
                            "Revenue: "
                                    + factRideRepository.getTotalRevenue()));

            document.add(
                    new Paragraph(
                            "Completed Rides: "
                                    + factRideRepository.countByStatus(
                                            "COMPLETED")));

            document.close();

        } catch (Exception e) {

            throw new RuntimeException(
                    "PDF Generation Failed",
                    e);
        }

        return fileName;
    }
}