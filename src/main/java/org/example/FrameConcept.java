package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FrameConcept {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://classic.crmpro.com/");
        Thread.sleep(4000);

        driver.findElement(By.name("username")).sendKeys("newautomation");
        driver.findElement(By.name("password")).sendKeys("Selenium@12345");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        Thread.sleep(3000);

        driver.switchTo().frame("mainpanel");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.linkText("CONTACTS"))).perform();
       // driver.findElement(By.linkText("CONTACTS")).click();

        List<WebElement> contactElements = driver.findElements(By.xpath("//a[text()='Contacts']/following-sibling::ul/li"));

        for(WebElement e: contactElements){
            String text = e.getText();
            if(text.equals("Combined Form")){
                e.click();
                break;
            }
        }

        driver.switchTo().defaultContent();

    }

}
