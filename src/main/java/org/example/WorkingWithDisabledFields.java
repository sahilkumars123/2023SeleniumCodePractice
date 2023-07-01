package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class WorkingWithDisabledFields {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //  ChromeDriver driver = new ChromeDriver();

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");

        By password = By.id("pass");

        ElementUtil elementUtil = new ElementUtil(driver);
        boolean status = elementUtil.isElementEnabled(password);
        System.out.println(status);

        brUtil.quitBrowser();
    }
}
