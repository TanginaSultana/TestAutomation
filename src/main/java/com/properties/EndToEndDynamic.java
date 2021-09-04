package com.properties;

import com.Base.TestBase;
import com.OpenCart.Login;
import com.OpenCart.Logout;
import com.OpenCart.Registration;

import java.io.IOException;

public class EndToEndDynamic extends TestBase {
    public static void main(String[] args) throws IOException {
        firefox_launch();
        openUrl("https://demo.opencart.com/");
        RandomEmail();
        Registration.OpenRegistrationPage();
        Registration.TC_Valid_Registration_properties();
        Logout.logOut();
        Login.OpenLoginPage();
        LoginWithProperties.TC_Valid_dynamic();
        Logout.logOut();
        firefox_close();
    }
}
