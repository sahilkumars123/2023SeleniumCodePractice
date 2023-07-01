package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class HandlingDropDownWithoutSelectTag {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        int[] array = {1,2,3,4,5};

        driver.findElement(By.xpath("//div[text()='Select Option']")).click();

        List<WebElement> optionsInSelectDropDown = driver.findElements(By.xpath("//div[contains(@id,'react-select-2-option')]"));

        for(WebElement e : optionsInSelectDropDown){
            String text = e.getText();
            System.out.println(text);
            if(text.contains("Group 1, option 2")){
                e.click();
                break;
            }
        }
    }
}
