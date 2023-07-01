package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginTest {
   static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/Users/sahil.kumar/Documents/drivers/chromedriver");

//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");

      //  ChromeDriver driver = new ChromeDriver();
        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

        System.out.println("Title of the page is:: "+brUtil.getTitle());

        By emailId = By.id("input-email");
        By password = By.id("input-password");
        By loginButton = By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
        By myAccountText = By.linkText("My Account");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(emailId,"sahil.kumar9274@gmail.com");
        elementUtil.doSendKeys(password,"Sahil@765");
        elementUtil.doClick(loginButton);
        String myAccount = elementUtil.doElementGetText(myAccountText);
        if(myAccount.equals("My Account"))
            System.out.println("Successfully Logged In");
        else
            System.out.println("Not Logged In");

        brUtil.quitBrowser();
    }
}



