package com.BrowserSetup;

import com.Base.TestBase;
import org.openqa.selenium.Dimension;

public class WindowSize extends TestBase {
    public static void main(String[] args) {
        chrome_launch();
        getWindowSize();
        setWindowSize(1000,500);
        chrome_close();
    }
    public static void getWindowSize(){
        int height=driver.manage().window().getSize().getHeight(); //744
        int width=driver.manage().window().getSize().getWidth();  //1382
        System.out.println("Full Window Height: "+height);
        System.out.println("Full Window Width: "+width);
    }

    public static void setWindowSize(int Width,int Height){
        driver.manage().window().setSize(new Dimension(Width,Height));

        int height=driver.manage().window().getSize().getHeight(); //744
        int width=driver.manage().window().getSize().getWidth();  //1382
        System.out.println("New Height: "+height);
        System.out.println("New Width: "+width);
    }
}
