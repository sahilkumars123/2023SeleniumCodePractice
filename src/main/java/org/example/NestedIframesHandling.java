package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedIframesHandling {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://selectorshub.com/iframe-scenario/");
        Thread.sleep(1500);

        driver.switchTo().frame("pact1");
        driver.findElement(By.id("inp_val")).sendKeys("First Crush");

        driver.switchTo().frame("pact2");
        driver.findElement(By.id("jex")).sendKeys("Current Crush");

        driver.switchTo().frame("pact3");
        driver.findElement(By.id("glaf")).sendKeys("Destiny Crush");

//        driver.switchTo().parentFrame();
//        driver.findElement(By.id("jex")).sendKeys(" Current Crush Updated");
//
//        driver.switchTo().parentFrame();
//        driver.findElement(By.id("inp_val")).sendKeys(" First Crush Updated");
//
//        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();
        String h3Text = driver.findElement(By.tagName("h3")).getText();
       System.out.println("Heading text:: "+h3Text);



    }
}
