package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
}