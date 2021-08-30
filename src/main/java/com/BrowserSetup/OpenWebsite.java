package com.BrowserSetup;

import com.Base.TestBase;

public class OpenWebsite extends TestBase {

    public static void main(String[] args) {
        firefox_launch();
        //chrome_launch();
        openUrl("file:///C:/Users/USER/Desktop/Software testing/download.html");
       // firefox_close();

    }
  // public static void openUrl(){
   //   driver.get("https://google.com");
   // }
}
