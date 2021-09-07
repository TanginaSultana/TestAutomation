package com.Alert;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllAboutAlert extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        firefox_launch();
        openUrl("https://the-internet.herokuapp.com/javascript_alerts");
        normalAlert();
        confirmAlert();
        promptAlert();
        firefox_close();

    }

    public static void normalAlert(){
        WebElement alertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button"));
        alertBtn.click();
        driver.switchTo().alert().accept();
    }
    public static void confirmAlert() throws InterruptedException {
        WebElement alertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button"));
        alertBtn.click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
    }
    public static void promptAlert() throws InterruptedException {
        WebElement alertBtn= driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button"));
        alertBtn.click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Test Automation");
        driver.switchTo().alert().accept();
    }

}
