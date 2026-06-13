package com.rapido.globalservice.invoice;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class InvoicePdfService {

    public byte[] generateInvoice(
            Invoice invoice
    ) {

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        PdfWriter writer =
                new PdfWriter(output);

        PdfDocument pdf =
                new PdfDocument(writer);

        Document document =
                new Document(pdf);

        document.add(
                new Paragraph("RAPIDO INVOICE")
        );

        document.add(
                new Paragraph(
                        "Customer: "
                                + invoice.getCustomerName()
                )
        );

        document.add(
                new Paragraph(
                        "Ride ID: "
                                + invoice.getRideId()
                )
        );

        document.add(
                new Paragraph(
                        "Currency: "
                                + invoice.getCurrencyCode()
                )
        );

        document.add(
                new Paragraph(
                        "Fare: "
                                + invoice.getFareAmount()
                )
        );

        document.add(
                new Paragraph(
                        "Tax: "
                                + invoice.getTaxAmount()
                )
        );

        document.add(
                new Paragraph(
                        "Total: "
                                + invoice.getTotalAmount()
                )
        );

        document.close();

        return output.toByteArray();
    }
}