package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllAboutDropDown extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        firefox_launch();
        openUrl("https://the-internet.herokuapp.com/dropdown");
        selectOptionByIndex();
        selectOptionByValue();
        selectOptionByVisibleText();
        firefox_close();
    }

    public static void selectOptionByIndex() throws InterruptedException {
        WebElement dropdwn=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropdwn);
        obj.selectByIndex(1);
        Thread.sleep(300);
    }
    public static void selectOptionByValue() throws InterruptedException {
        WebElement dropdwn=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropdwn);
        obj.selectByValue("2");
        Thread.sleep(300);
    }
    public static void selectOptionByVisibleText() throws InterruptedException {
        WebElement dropdwn=driver.findElement(By.id("dropdown"));
        Select obj=new Select(dropdwn);
        obj.selectByVisibleText("Option 1");
        Thread.sleep(300);
    }
}