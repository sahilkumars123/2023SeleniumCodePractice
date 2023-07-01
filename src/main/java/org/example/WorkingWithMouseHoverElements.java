package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class WorkingWithMouseHoverElements {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


            System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

            BrowserUtil brUtil = new BrowserUtil();
            driver = brUtil.intializeBrowser("chrome");
            brUtil.launchURL("http://mrbool.com/search/?txtsearch=how+to+create+menu+with+submenu+usingg+css+html&o=rec");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));


            By parentMenuLink = By.className("menulink");
            clickChildElement(parentMenuLink, "Courses");
    }

    public static WebElement getElement(By locator){

        return driver.findElement(locator);
    }
    public static void clickChildElement(By locator, String childValue) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(locator)).build().perform();
       // By childLocator = By.xpath("//*[@class='submenu']/*/a[text()='"+childValue+"']");
        By childLocator = By.linkText(childValue);
        getElement(childLocator).click();
    }
}
