package com.OpenCart;

import com.Base.TestBase;

import java.io.FileNotFoundException;
import java.io.IOException;

public class EndToEnd extends TestBase {
    public static void main(String[] args) throws IOException {
        String HomePage="https://demo.opencart.com/";
        chrome_launch();
        openUrl(HomePage);
        Registration.OpenRegistrationPage();
        Registration.TC_Valid_Registration();
        Logout.logOut();
        Login.OpenLoginPage();
        Login.TC_Valid_loginTest();
        Logout.logOut();
    }
}
