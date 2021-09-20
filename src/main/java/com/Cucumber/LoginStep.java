package com.Cucumber;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStep {
    WebDriver driver;

    @Given("Open Browser and Navigate to login page")
    public void open_browser_and_navigate_to_login_page() {

        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/index.php?route=account/login");

    }
    @When("Enter Email and Password")
    public void enter_email_and_password() {

        WebElement Email=driver.findElement(By.name("email"));
        Email.sendKeys("invalid@gmail.com");
        WebElement Password=driver.findElement(By.name("password"));
        Password.sendKeys("123456");
        WebElement LoginBtn=driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));
        LoginBtn.click();

    }
    @Then("Login Unsuccessful and close Test")
    public void login_unsuccessful_and_close_test() {

        //Logic for pass/fail
        String Expected_Title="Account Login";
        String Actual_Title=driver.getTitle();

        if(Expected_Title.equals(Actual_Title)){
            System.out.println("Test Passed");
        }

        else {
            System.out.println("Test Failed");

        }
        driver.close();

    }

}
