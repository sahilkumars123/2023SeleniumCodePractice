    package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HandlingDSEDropDown {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://stagingadmin.dsetrucks.com.au/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        By emailID = By.name("email");
        By password = By.name("password");
        By signInButton = By.xpath("//form[@id='login']//button[text()='Sign In']");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(emailID,"shikha.koul@prajal.com");
        elementUtil.doSendKeys(password,"1234DSE5679");
        elementUtil.doClick(signInButton);

        driver.get("https://stagingadmin.dsetrucks.com.au/job?timezone=Asia/Kolkata");

        WebElement driverDropDown = driver.findElement(By.id("drivers"));
       // WebElement dropDownButton = driver.findElement(By.xpath("//button[@title='Driver']"));

        Actions actions = new Actions(driver);
        actions.click(driverDropDown).perform();

        //driverDropDown.click();

        Select select = new Select(driverDropDown);
        if(select.isMultiple()){
           // System.out.println("Hello World");
            select.selectByValue("123");
            select.selectByValue("124");
        }
        else {
            System.out.println("Hello World");
        }

    }

}
