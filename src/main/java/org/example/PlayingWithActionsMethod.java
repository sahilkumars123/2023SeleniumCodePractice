package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class PlayingWithActionsMethod {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");
        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("http://omayo.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("compendiumdev"))).
                    keyDown(Keys.CONTROL).
                        click().
                            keyUp(Keys.CONTROL).
                                            build().perform();


        //** Using Ctrl+a and Ctrl+v *****//


//        WebElement textAreaField2 = driver.findElement(By.xpath("//h2[text()='Text Area Field Two']/following::textarea"));
//
//        WebElement textAreaField3 = driver.findElement(By.id("ta1"));
//
//        Thread.sleep(2000);
////
//        textAreaField2.sendKeys(Keys.chord(Keys.CONTROL,"a"));
//        Thread.sleep(3000);
//        textAreaField2.sendKeys(Keys.chord(Keys.CONTROL,"x"));
//        Thread.sleep(3000);
//        textAreaField3.sendKeys(Keys.chord(Keys.CONTROL,"v"));

//        textAreaField2.sendKeys(Keys.CONTROL+"a");
//        Thread.sleep(3000);
//        textAreaField2.sendKeys(Keys.CONTROL+"x");
//        Thread.sleep(3000);
//        textAreaField3.sendKeys(Keys.CONTROL+"v");
//        Thread.sleep(3000);





    }


}
