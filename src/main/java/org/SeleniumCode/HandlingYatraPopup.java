package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingYatraPopup {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

//        BrowserUtil brUtil = new BrowserUtil();
//        driver = brUtil.intializeBrowser("chrome");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");


        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.yatra.com/");
       // brUtil.launchURL("https://www.yatra.com/");
        Thread.sleep(4000);

        driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
        driver.findElement(By.id("webklipper-publisher-widget-container-notification-close-div")).click();
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//button[text()='Ok,I Agree']")).click();

//        String pageTitle = driver.getTitle();
//        System.out.println("Page Title:: "+pageTitle);

    }
}
