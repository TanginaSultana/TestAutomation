package com.Base;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class TestBase {
    public static WebDriver driver;

    public static void firefox_launch()
    {
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
    }
    public static void firefox_close(){
        driver.close();
    }

    public static void chrome_launch() {
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }
    public static void chrome_close(){
        driver.close();
    }

    public static void openUrl(String URL){
        driver.get(URL);
    }

    public static String RandomEmail() throws IOException {
        FileOutputStream fis=new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop=new Properties();

        String SALTCHAR="abcdefAbcdef1234";
        StringBuilder salt=new StringBuilder();
        Random rnd=new Random();

        while (salt.length()<5){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));
        }
        String saltStr=salt.toString().concat("@gmail.com");
        prop.setProperty("RandomEmail",saltStr);
        prop.store(fis,null);
        return saltStr;
    }

    public static void generateScreenshot(String name) throws IOException {
        //Capture
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //save
        FileUtils.copyFile(srcFile,new File("./src/main/Screenshots/"+name+".png"),true);
        System.out.println("Image captured and saved.");
    }

    public static void createPDF(String Name) throws IOException, DocumentException {
        //take a screenshot as byte
        byte[] input = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Document doc = new Document();
        String output = "./src/main/PDF/"+Name+".pdf";

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