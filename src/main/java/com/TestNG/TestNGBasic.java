package com.TestNG;

import javafx.scene.layout.Priority;
import org.testng.annotations.Test;

public class TestNGBasic {
    @Test(enabled = false)
    public static void testMethod1(){
        System.out.println("TestNG");
    }

    @Test(priority = 1)
    public static void testMethod2(){
        System.out.println("Test Automation");
    }

    @Test(description = "Test description")
    public static void testMethod3(){
        System.out.println("Selenium");
    }
}
