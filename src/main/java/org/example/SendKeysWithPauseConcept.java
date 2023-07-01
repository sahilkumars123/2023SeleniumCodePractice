package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SendKeysWithPauseConcept {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        String first_name = "SahilKumarLabs";
        By firstName = By.id("input-firstname");
        Actions actions = new Actions(driver);
        WebElement name = driver.findElement(firstName);
        String text = name.getText();
        char[] text_part2 = first_name.toCharArray();

        for(int i=0; i< text_part2.length; i++){
            actions.sendKeys(name,String.valueOf(text_part2[i])+" ").pause(500).perform();
        }
    }
}
