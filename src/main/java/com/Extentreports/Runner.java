package com.Extentreports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(features = "C:\\Users\\USER\\Desktop\\Software testing\\Test code\\TestAutomation\\src\\main\\java\\com\\Cucumber\\LoginTest.feature",
        glue = {"com.Cucumber"},
        plugin = {
        "pretty","html:CucumberReports/LoginBDD.html"
        },
        monochrome = true

)

@RunWith(Cucumber.class)

public class Runner {

}
