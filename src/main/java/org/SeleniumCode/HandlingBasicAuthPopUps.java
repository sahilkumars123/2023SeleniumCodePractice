package org.SeleniumCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBasicAuthPopUps {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        String username = "admin";
        String password = "admin";

        WebDriver driver = new ChromeDriver();
        driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");

        //basic auth??
        //username:password --> encoded string
        //btoa("username:password") --> ERQWERQWERQWER!@#$@!#$===

    }
}
