package com.DataDriven;

import com.Utils.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DD_LoginTest {
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

    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @Test(description = "Email and Password are InValid.")
    public void TC_Valid_001() throws InterruptedException {
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/main/TestData/LoginData.xlsx");
        String sheetName="Sheet1";

        int rowCount= reader.getRowCount(sheetName);

        for(int rowNum=2;rowNum<=rowCount;rowNum++){
            String email=reader.getCellData(sheetName,"Email",rowNum);
            String pass=reader.getCellData(sheetName,"Password",rowNum);

            //Login
            WebElement Email=driver.findElement(By.name("email"));
            Email.clear();
            Email.sendKeys(email);
            Thread.sleep(3000);
            WebElement Password=driver.findElement(By.name("password"));
            Password.clear();
            Password.sendKeys(pass);
            Thread.sleep(3000);
            WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
            LoginBtn.click();

            //Logic for pass/fail
            String Expected_Title="Account Login";
            String Actual_Title=driver.getTitle();

            if(Expected_Title.equals(Actual_Title)){
                //Write on Excel
                reader.setCellData(sheetName,"Result",rowNum,"Passed");
            }
            else {
                //Write on Excel
                reader.setCellData(sheetName,"Result",rowNum,"Failed");
            }
        }

    }

}