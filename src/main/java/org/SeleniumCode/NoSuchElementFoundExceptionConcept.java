package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class NoSuchElementFoundExceptionConcept {
    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //  ChromeDriver driver = new ChromeDriver();
        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        By forgotten_password = By.linkText("Forgotten Password11");

        try {
            driver.findElement(forgotten_password).click();
        }
        catch (NoSuchElementException e){
            System.out.println("Element not found. Please check your locator carefully");
        }

        System.out.println(driver.getTitle());
    }
}
