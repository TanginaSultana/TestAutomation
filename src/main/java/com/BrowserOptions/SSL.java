package com.BrowserOptions;

import com.Base.TestBase;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class SSL extends TestBase {
    public static void main(String[] args) {
        insecureCerts();
        firefox_close();
    }
    public static void insecureCerts(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        FirefoxOptions frxObj=new FirefoxOptions();
        frxObj.setAcceptInsecureCerts(true);
        driver=new FirefoxDriver();
        driver.get("https://cacert.org/");
        System.out.println(driver.getTitle());
    }
}