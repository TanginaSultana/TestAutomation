package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
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

    public static String RandomName() throws IOException {
        return getString();
    }

    public static String getString() throws IOException {
        return getString();
    }
}
