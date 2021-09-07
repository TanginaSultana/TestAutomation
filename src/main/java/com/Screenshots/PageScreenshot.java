package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        firefox_launch();
        openUrl("https://google.com");
        generateScreenshot("newImage");
        firefox_close();

    }
    public static void generateScreenshot(String name) throws IOException {
        //Capture
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //save
        FileUtils.copyFile(srcFile,new File("./src/main/Screenshots/"+name+".png"),true);
        System.out.println("Image captured and saved.");
    }


}
