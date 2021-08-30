package com.properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class WriteProperties {
    public static void main(String[] args) throws IOException {
        FileOutputStream fis = new FileOutputStream("./src/main/resources/Data.properties");
        Properties prop=new Properties();
        prop.setProperty("Name","Tangina Sultana");
        prop.setProperty("Email","tanginaislam520@gmail.com");
        prop.store(fis,null);

    }

}
