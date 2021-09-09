package com.PDF;

import com.Base.TestBase;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class GeneratePDF extends TestBase {
    public static void main(String[] args) throws DocumentException, IOException {
        firefox_launch();
        openUrl("https://bbc.com");
        createPDF();
        firefox_close();
    }

    public static void createPDF() throws IOException, DocumentException {
        //take a screenshot as byte
        byte[] input = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Document doc = new Document();
        String output = "./src/main/PDF/NewPdf.pdf";

        FileOutputStream fs =new FileOutputStream(output);
        PdfWriter writer = PdfWriter.getInstance(doc,fs);
        writer.open();

        doc.open();
        Image img = Image.getInstance(input);
        img.scaleToFit(PageSize.A4.getWidth()/2,PageSize.A4.getHeight()/2);
        doc.add(img);

      //  doc.add(new Paragraph(""));
        doc.close();

        writer.close();
        System.out.println("PDF generated successfully.");

    }
}
