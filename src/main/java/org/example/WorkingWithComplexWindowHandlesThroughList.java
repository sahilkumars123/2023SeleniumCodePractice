package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WorkingWithComplexWindowHandlesThroughList {

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

        List<String> listOfSessionIds = new ArrayList<>(setOfOpenedWindows);

        for(String s: listOfSessionIds){
            driver.switchTo().window(s);
            System.out.println("Title is:: "+driver.getTitle());
            if(!parentWindowId.equals(s)){
                driver.close();
            }
        }

        driver.switchTo().window(parentWindowId);
        System.out.println("Current URL is:: "+driver.getCurrentUrl());
        driver.quit();
    }
}
