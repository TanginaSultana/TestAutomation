package com.BrowserOptions;

import com.Base.TestBase;
import com.OpenCart.Login;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessTest extends TestBase {
    public static void main(String[] args) {
        chromeHeadless();
        chrome_close();
        firefoxHeadless();
        firefox_close();
    }
    public static void chromeHeadless(){
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions chromObj=new ChromeOptions();
        chromObj.setHeadless(true);
        driver=new ChromeDriver(chromObj);
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        Login.TC_Valid_loginTest();
        System.out.println("Login Success");
    }
    public static void firefoxHeadless(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        FirefoxOptions firefoxObj=new FirefoxOptions();
        firefoxObj.setHeadless(true);
        driver=new FirefoxDriver(firefoxObj);
        driver.get("https://demo.opencart.com/index.php?route=account/login");
        Login.TC_Valid_loginTest();
        System.out.println("Login Success");
    }
}