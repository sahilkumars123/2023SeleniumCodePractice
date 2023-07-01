package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BigBasketMultiLevelMenuHandling {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.bigbasket.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        By level1locator = By.xpath("//a[@qa='categoryDD']");

        muliLevelMenuHandling(level1locator,"Beverages","Tea","Green Tea");

    }
    public static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public static WebElement getLinkEleByText(String text){
       return driver.findElement(By.linkText(text));
    }

    public static void muliLevelMenuHandling(By level1locator, String level2, String level3, String level4) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(level1locator)).perform();
        Thread.sleep(2000);
        actions.moveToElement(getLinkEleByText(level2)).perform();
        Thread.sleep(2000);
        actions.moveToElement(getLinkEleByText(level3)).perform();
        Thread.sleep(2000);
        getLinkEleByText(level4).click();
    }

}
