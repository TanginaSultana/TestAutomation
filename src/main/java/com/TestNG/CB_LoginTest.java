package com.TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CB_LoginTest {
    WebDriver driver;

    @BeforeClass
    @Parameters("Browser")
    public void initSetup(String browserName){
        if(browserName.equalsIgnoreCase("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver","./src/main/resources/geckodriver.exe");
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if(browserName.equalsIgnoreCase("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        }
        else{
            System.out.println("No Browser Found");
        }

        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(priority = 1,description = "Email and Password are Valid.")
    public void TC_Valid_001() throws InterruptedException {
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("123456");
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

        //Logout
        driver.findElement(By.linkText("Logout")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Login")).click();
        Thread.sleep(3000);

        System.out.println("TC_Valid_001 Executed");
    }

    @Test(priority = 2,description = "Email valid and Password InValid.")
    public void TC_InValid_002() throws InterruptedException {
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail.com");
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("zas22");
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
        System.out.println("TC_InValid_002 Executed");
    }
    @Test(priority = 3,description = "Email and Password are InValid.")
    public void TC_InValid_003() throws InterruptedException {
        WebElement Email=driver.findElement(By.name("email"));
        Email.clear();
        Email.sendKeys("user101@gmail");
        Thread.sleep(3000);
        WebElement Password=driver.findElement(By.name("password"));
        Password.clear();
        Password.sendKeys("");
        Thread.sleep(3000);
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();
        System.out.println("TC_InValid_003 Executed");
    }
}