package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class ElementScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        firefox_launch();
        openUrl("https://demo.opencart.com/");
        captureElement("CartImage");
        firefox_close();
    }

    public static void captureElement(String name) throws IOException {
        WebElement btn = driver.findElement(By.cssSelector("#cart > button"));
        //Capture
        File srcFile=((TakesScreenshot)btn).getScreenshotAs(OutputType.FILE);

        //save
        FileUtils.copyFile(srcFile,new File("./src/main/Screenshots/"+name+".png"),true);
        System.out.println("Image captured and saved.");
    }
}
