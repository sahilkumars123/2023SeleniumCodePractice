package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleLanguageSearch {

    static WebDriver driver;

        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

            BrowserUtil brUtil = new BrowserUtil();
            driver = brUtil.intializeBrowser("chrome");
            brUtil.launchURL("https://www.google.com/");

            By langLinks = By.xpath("//div[@id='SIvCob']/a");

            ElementUtil elementUtil = new ElementUtil(driver);
            elementUtil.clickOnElementByTakingList(langLinks,"मराठी");
           // clickOnElement(langLinks,"मराठी");
            driver.quit();
    }

}
