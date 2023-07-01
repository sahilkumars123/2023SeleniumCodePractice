package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithDropDownAtrributeValues {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.orangehrm.com/en/contact-sales/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        By countryDropDown = By.xpath("//select[@id='Form_getForm_Country']/option");

        ElementUtil elementUtil = new ElementUtil(driver);

       List<String> getAllValues =  elementUtil.printAttributeValue(countryDropDown,"value");

       if(getAllValues.contains("India")){
           System.out.println("PASS");
       }
       else {
           System.out.println("FAIL");
       }
    }

    public static List<WebElement> findElements(By locator){

       return driver.findElements(locator);
    }

}
