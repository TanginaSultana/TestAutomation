package com.Frames;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iFrameTest extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        firefox_launch();
        openUrl("https://the-internet.herokuapp.com/iframe");
        singleFrame();
        firefox_close();
    }
    public static void singleFrame() throws InterruptedException {
        driver.switchTo().frame("mce_0_ifr");
        WebElement iFrameBody=driver.findElement(By.id("tinymce"));
        iFrameBody.clear();
        iFrameBody.sendKeys("Test Automation");
        Thread.sleep(3000);
    }
}