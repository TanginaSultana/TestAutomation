package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Registration {
    WebDriver driver;
    @BeforeClass
    public void initSetup(){
        System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/register");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @DataProvider(name = "LoginData")
    public Object [][] data(){
        Object [][] data =new Object[3][6];

        //Set1
        data [0][0]="Tangina";
        data [0][1]="Sultana";
        data [0][2]="tangi@gmail.com";
        data [0][3]="123456789";
        data [0][4]="123456";
        data [0][5]="123456";

        //Set=2
        data [1][0]="Samanta";
        data [1][1]="Jannat";
        data [1][2]="saman@gmail.com";
        data [1][3]="12345678988";
        data [1][4]="1234567";
        data [1][5]="1234567";

        //Set3
        data [2][0]="Sadia";
        data [2][1]="Afroz";
        data [2][2]="sadi@gmail.com";
        data [2][3]="12345678413";
        data [2][4]="12345622";
        data [2][5]="12345622";

        return data;
    }

    @Test(dataProvider = "LoginData")
    public void TC_Valid(String DP_first,String DP_last,String DP_Email,String DP_TeleP,String DP_Pass,String DP_ConPass) throws InterruptedException {
        WebElement Firstname= driver.findElement(By.name("firstname"));
        Firstname.clear();
        Firstname.sendKeys(DP_first);
        Thread.sleep(3000);

        WebElement Lastname= driver.findElement(By.name("lastname"));
        Lastname.clear();
        Lastname.sendKeys(DP_last);
        Thread.sleep(3000);

        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys(DP_Email);
        Thread.sleep(3000);

        WebElement Telephone=driver.findElement(By.name("telephone"));
        Telephone.clear();
        Telephone.sendKeys(DP_TeleP);
        Thread.sleep(3000);

        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys(DP_Pass);
        Thread.sleep(3000);

        WebElement Password_Confirm=driver.findElement(By.name("confirm"));
        Password_Confirm.clear();
        Password_Confirm.sendKeys(DP_ConPass);
        Thread.sleep(3000);

        WebElement agree_btn= driver.findElement(By.name("agree"));
        agree_btn.click();

        WebElement con_btn= driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));
        con_btn.click();
        System.out.println("TC_Valid Executed");
    }
}
