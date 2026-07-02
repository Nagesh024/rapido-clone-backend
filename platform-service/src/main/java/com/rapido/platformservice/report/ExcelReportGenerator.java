package com.rapido.platformservice.report;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

public class ExcelReportGenerator {

    public void generate() throws Exception {

        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Executive Report");

        Row row = sheet.createRow(0);

        row.createCell(0).setCellValue("Daily Operations Report");
        row.createCell(1).setCellValue("Weekly Executive Report");
        row.createCell(2).setCellValue("Monthly Business Review");

        FileOutputStream output =
                new FileOutputStream("ExecutiveReport.xlsx");

        workbook.write(output);

        workbook.close();

        output.close();

    }

}