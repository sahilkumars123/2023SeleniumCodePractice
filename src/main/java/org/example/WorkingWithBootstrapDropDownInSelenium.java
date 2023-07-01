package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class WorkingWithBootstrapDropDownInSelenium {

    static WebDriver driver;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //  ChromeDriver driver = new ChromeDriver();
        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://getbootstrap.com/docs/5.0/components/dropdowns/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"dropdownMenuLink\").click()");


       List<WebElement> dropDownmenus = driver.findElements(By.xpath("//a[@id='dropdownMenuLink']//following-sibling::ul/li"));

       for (WebElement menu : dropDownmenus){
           if(menu.getText().equals("Actions")){
               menu.click();
           }
       }
       driver.quit();
    }
}
