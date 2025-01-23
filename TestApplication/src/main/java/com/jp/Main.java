package com.jp;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello, World!");
        Customer customer = new Customer();
        String result = customer.defineCustomer(5205,"JP");
        System.out.println(result);

        Properties properties = new Properties();

        // Load properties from the file
        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);

            // Access properties
            String appName = properties.getProperty("app.name");
            String appVersion = properties.getProperty("app.version");
            String appDescription = properties.getProperty("app.description");

            // Print the values
            System.out.println("App Name: " + appName);
            System.out.println("App Version: " + appVersion);
            System.out.println("App Description: " + appDescription);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}