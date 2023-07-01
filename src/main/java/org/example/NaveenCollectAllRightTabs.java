package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NaveenCollectAllRightTabs {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        ElementUtil elementUtil = new ElementUtil(driver);
        By links = By.xpath("//div[@class='list-group']/a");
        elementUtil.clickOnElementByTakingList(links,"My Account");
    }
}
