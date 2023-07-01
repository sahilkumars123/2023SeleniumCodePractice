package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //  ChromeDriver driver = new ChromeDriver();
        BrowserUtil brUtil = new BrowserUtil();
        WebDriver driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

        By firstName = By.id("input-firstname");
        By lastName = By.id("input-lastname");
        By emailId = By.id("input-email");
        By telephoneNumber = By.id("input-telephone");
        By password = By.id("input-password");
        By confirmPassword = By.id("input-confirm");
        By privacyPolicyCheckbox = By.name("agree");
        By continueButton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(firstName,"sahil");
        elementUtil.doSendKeys(lastName,"kumar");
        elementUtil.doSendKeys(emailId,"sahil.kumar9274@gmail.com");
        elementUtil.doSendKeys(telephoneNumber,"9876778283");
        elementUtil.doSendKeys(password,"Sahil@765");
        elementUtil.doSendKeys(confirmPassword,"Sahil@765");
        elementUtil.doClick(privacyPolicyCheckbox);
        elementUtil.doClick(continueButton);

        driver.quit();
    }
}
