package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchText {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.google.com/");


        By search = By.name("q");
        By suggestionList = By.xpath("//ul[@role='listbox']//div[@role='presentation' and @class='wM6W7d']/span");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSearch(search,suggestionList,"naveen automation labs","youtube");
    }


}
