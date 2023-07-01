package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HandlingFileUpload {
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

        driver.get("https://stagingadmin.dsetrucks.com.au/customer-search-list?timezone=Asia/Kolkata");

        driver.findElement(By.xpath("//input[@placeholder='Choose file']"))
                .sendKeys("/Users/sahil.kumar/Downloads/SahilQA_5.5Yrs.pdf");

        driver.findElement(By.xpath("//button[text()='Import Customers']")).click();
        Thread.sleep(3000);

    }

}
