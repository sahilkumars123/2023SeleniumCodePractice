package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class WorkingWithDragAndDropElements {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://jqueryui.com/resources/demos/droppable/default.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

       WebElement draggable = driver.findElement(By.id("draggable"));
       WebElement droppable =  driver.findElement(By.id("droppable"));

        String colorBeforeDnD = droppable.getCssValue("color");

        System.out.println("color before is:: "+colorBeforeDnD);

        Actions actions = new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(droppable).release().build().perform();
        //actions.dragAndDrop(draggable,droppable).build().perform();

        String colorAfterDnD = droppable.getCssValue("color");

        System.out.println("color after is:: "+colorAfterDnD);

    }
}
