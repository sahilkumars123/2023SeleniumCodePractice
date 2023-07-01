package org.SeleniumCode;

import org.openqa.selenium.*;

import java.time.Duration;

public class ResizingWindowsConcept {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

       WebElement registerButton = driver.findElement(By.linkText("Register"));

        Dimension d = new Dimension(480,620);
        driver.manage().window().setSize(d);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", registerButton);


       // driver.quit();
    }
}
