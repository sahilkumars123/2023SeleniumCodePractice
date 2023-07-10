package org.SeleniumCode;

import org.openqa.selenium.WebDriver;

public class DisabledFields {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");



    }
}
