package com.Navigation;

import com.Base.TestBase;
import org.openqa.selenium.By;

public class NavigationTest extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        NavigationTo();
        NavigationBack();
        NavigationRefresh();
        NavigationForward();
        chrome_close();
    }

    public static void NavigationTo(){
        driver.navigate().to("https://google.com/");
        System.out.println("Navigation To: "+driver.getTitle());

    }
    public static void NavigationForward(){
        driver.navigate().forward();
        System.out.println("Navigation Forward: "+driver.getTitle());

    }
    public static void NavigationBack(){
        driver.navigate().back();
        System.out.println("Navigation Back: "+driver.getTitle());

    }
    public static void NavigationRefresh() throws InterruptedException {
        driver.findElement(By.name("search")).sendKeys("Mackbook");
        Thread.sleep(5000);
        driver.navigate().refresh();

    }
}
