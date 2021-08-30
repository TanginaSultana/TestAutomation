package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends TestBase {
    public static void main(String[] args) {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        Login.OpenLoginPage();
        Login.TC_Valid_loginTest();
        logOut();
    }

    public static void logOut(){
        WebElement Logout=driver.findElement(By.linkText("Logout"));
        Logout.click();
    }
}