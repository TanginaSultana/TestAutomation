package com.Locators;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementLocator extends TestBase {
    public static void main(String[] args) {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        OpenRegisterPage();
       // OpenLoginPage();
        //TC_loginTest();
        TC_RegisterTest();
    }
    public static void OpenLoginPage(){
        WebElement MyAccount=driver.findElement(By.linkText("My Account"));
        MyAccount.click();
        WebElement Login=driver.findElement(By.linkText("Login"));
        Login.click();
    }
    public static void OpenRegisterPage(){
        WebElement MyAccount=driver.findElement(By.linkText("My Account"));
        MyAccount.click();
        WebElement Register=driver.findElement(By.linkText("Register"));
        Register.click();
    }

    public static void TC_loginTest(){
       WebElement Email=driver.findElement(By.name("email"));
       Email.sendKeys("mail@mail.com");
       WebElement Password=driver.findElement(By.name("password"));
       Password.sendKeys("123456");
       WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
       LoginBtn.click();
     }
    public static void TC_RegisterTest(){
        WebElement FirstName=driver.findElement(By.name("firstname"));
        FirstName.sendKeys("Tangina");
        WebElement LastName=driver.findElement(By.name("lastname"));
        LastName.sendKeys("Sultana");
        WebElement Email=driver.findElement(By.name("email"));
        Email.sendKeys("mail3@mail.com");
        WebElement Telephone=driver.findElement(By.name("telephone"));
        Telephone.sendKeys("123456");
        WebElement Password=driver.findElement(By.name("password"));
        Password.sendKeys("123456");
        WebElement PasswordConfirm=driver.findElement(By.name("confirm"));
        PasswordConfirm.sendKeys("123456");
        WebElement Subscribe=driver.findElement(By.name("newsletter"));
        Subscribe.sendKeys("1");
        WebElement PrivacyPolicy=driver.findElement(By.name("agree"));
        PrivacyPolicy.click();
        WebElement Continue=driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        Continue.click();

    }
}
