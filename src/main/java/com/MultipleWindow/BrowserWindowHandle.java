package com.MultipleWindow;

import com.Base.TestBase;
import org.openqa.selenium.By;

import java.util.Iterator;
import java.util.Set;

public class BrowserWindowHandle extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        firefox_launch();
        openUrl("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.xpath("//*[@id=\"social-icons\"]/a[3]/img")).click(); //Child window

        Set<String> handles=driver.getWindowHandles();

        Iterator <String> it=handles.iterator();
        String parentWindowID=it.next();
        System.out.println("Parent window ID is : "+parentWindowID);

        String childWindowID=it.next();
        System.out.println("Child window ID is : "+childWindowID);

        //Switching
        driver.switchTo().window(childWindowID);
        Thread.sleep(3000);
        System.out.println("Child Window URL :" +driver.getCurrentUrl());
        // driver.close();

        driver.switchTo().window(parentWindowID);
        System.out.println("Parent Window URL :" +driver.getCurrentUrl());
        driver.navigate().to("https://google.com");
        System.out.println("Parent new Webpage Title :" +driver.getTitle());
        // driver.close();

        driver.quit();

    }

}