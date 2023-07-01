package org.example;

import org.openqa.selenium.WebDriver;

public class WindowHandle {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //  ChromeDriver driver = new ChromeDriver();
        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");


        driver.manage().deleteAllCookies();

        String parentWindow =driver.getWindowHandle();
    }
}
