package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsMethodChaining {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Actions actions = new Actions(driver);

        WebElement firstName = driver.findElement(By.id("input-firstname"));

        actions.sendKeys(firstName, "sahil")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys("kumar")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys("sahil@yopmail.com")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys("9876778283")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys("Sahil@765")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys("Sahil@765")
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys(Keys.TAB)
                .pause(1000)
                .sendKeys(Keys.SPACE).perform();

    }

}
