package com.rapido.globalservice.invoice;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    private final InvoicePdfService pdfService;

    public InvoiceController(
            InvoicePdfService pdfService
    ) {
        this.pdfService = pdfService;
    }

    @GetMapping("/pdf")
    public ResponseEntity<byte[]> generate() {

        Invoice invoice =
                new Invoice();

        invoice.setCountryCode("IN");
        invoice.setCurrencyCode("INR");
        invoice.setCustomerName("Test Customer");
        invoice.setRideId("RIDE-1001");

        invoice.setFareAmount(
                new BigDecimal("1000.00")
        );

        invoice.setTaxAmount(
                new BigDecimal("180.00")
        );

        invoice.setTotalAmount(
                new BigDecimal("1180.00")
        );

        byte[] pdf =
                pdfService.generateInvoice(
                        invoice
                );

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=invoice.pdf"
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .body(pdf);
    }
}