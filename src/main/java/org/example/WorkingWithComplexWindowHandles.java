package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class WorkingWithComplexWindowHandles {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.dsetrucks.com.au/");

        String parentWindowId = driver.getWindowHandle();

        Thread.sleep(2000);

        WebElement facebook = driver.findElement(By.xpath("//a[contains(@href,'facebook')]"));
        WebElement twitter = driver.findElement(By.xpath("//a[contains(@href,'twitter')]"));
        WebElement instagram = driver.findElement(By.xpath("//a[contains(@href,'instagram')]"));
        WebElement linkedIn = driver.findElement(By.xpath("//a[contains(@href,'linkedin')]"));

        facebook.click();
        twitter.click();
        instagram.click();
        linkedIn.click();

         Set<String> setOfOpenedWindows = driver.getWindowHandles();

         Iterator<String> it = setOfOpenedWindows.iterator();

         while (it.hasNext()){
             String currentSessionId = it.next();
             driver.switchTo().window(currentSessionId);
             String title = driver.getTitle();
             System.out.println("Title is:: "+title);
             if(!parentWindowId.equals(currentSessionId))
                    driver.close();
         }

         driver.switchTo().window(parentWindowId);
        System.out.println("Current URL:: "+driver.getCurrentUrl());

    }
}
