package com.Browsers;

import com.Base.TestBase;
import com.OpenCart.Login;

public class TitleAndUrlVerify extends TestBase {
    public static void main(String[] args) {
        chrome_launch();
        openUrl("https://demo.opencart.com/");
        Login.OpenLoginPage();
        Tc_Valid_Title_Verify();
        Tc_Valid_Url_Verify();
        chrome_close();
    }
    public static void Tc_Valid_Title_Verify(){
        String ExpectedTitle="Account Login";
        String ActualTitle=driver.getTitle();
        if (ExpectedTitle.equals(ActualTitle)){
            System.out.println("Test Passed,Login page open.Title Verified.");
        }
        else {
            System.out.println("Test Failed,Different page open.");
        }

    }
    public static void Tc_Valid_Url_Verify(){
        String ExpectedUrl="https://demo.opencart.com/index.php?route=account/login";
        String ActualUrl=driver.getCurrentUrl();
        if (ExpectedUrl.equals(ActualUrl)){
            System.out.println("Test Passed,Login page open.URL Verified.");
        }
        else {
            System.out.println("Test Failed,Different page open.");
        }

    }

}