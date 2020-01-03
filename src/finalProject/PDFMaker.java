/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalProject;

import com.itextpdf.text.Document;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author splimter
 */
public abstract class PDFMaker {

    static String clientName;
    static String reservationDate;
    static String TimeSpen;
    static String RoomType;
    static String RoomTypePrice;
    static String AdditionalTax;
    static String TotalPrice;

    static void setCheckout() throws DocumentException {
        Document document = new Document();

        Path path = null;

        try {
            path = Paths.get(PDFMaker.class.getResource("lib/logo.jpg").toURI());
        } catch (URISyntaxException ex) {
            Logger.getLogger(PDFMaker.class.getName()).log(Level.SEVERE, null, ex);
        }

        Image img = null;
        try {
            img = Image.getInstance(path.toAbsolutePath().toString());
        } catch (BadElementException | IOException ex) {
            Logger.getLogger(PDFMaker.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            PdfWriter.getInstance(document, new FileOutputStream("checkout.pdf"));
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(PDFMaker.class.getName()).log(Level.SEVERE, null, ex);
        }

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK),
                fontSubBody = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK),
                fontBody = FontFactory.getFont(FontFactory.COURIER, 12, BaseColor.BLACK);

        
        try {
            document.add(img);
            document.add(new Paragraph("Dear " + clientName, fontTitle));
            document.add(new Paragraph("\nThank you for having you with us, we hope you did enjoy.", fontSubBody));
            document.add(new Paragraph("\n\n", fontBody));
            document.add(new Paragraph("\nReservation Date ............. " + reservationDate + " (" + TimeSpen + " days)", fontBody));
            document.add(new Paragraph("\nRoom ......................... " + RoomType + " (" + RoomTypePrice + " da)", fontBody));
            document.add(new Paragraph("\nAdditional Tax ............... " + AdditionalTax, fontBody));
            document.add(new Paragraph("\n\nTotalPrice ................... " + TotalPrice +" da", fontBody));
        } catch (DocumentException ex) {
            Logger.getLogger(PDFMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
    }

}
