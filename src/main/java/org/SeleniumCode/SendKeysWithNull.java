package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SendKeysWithNull {

   static WebDriver driver;
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");


        By firstName = By.id("input-firstname");

        ElementUtil elementUtil = new ElementUtil(driver);
        //elementUtil.doSendKeys(firstName,null);
        //driver.findElement(firstName).sendKeys("");
        //driver.findElement(firstName).sendKeys(" ");
        //driver.findElement(firstName).sendKeys(123);


        String str = "Naveen";
        StringBuilder sb = new StringBuilder("Automation");
        StringBuffer sf = new StringBuffer("Labs");

        driver.findElement(firstName).sendKeys(str,sb,sf);

        driver.quit();


    }
}
