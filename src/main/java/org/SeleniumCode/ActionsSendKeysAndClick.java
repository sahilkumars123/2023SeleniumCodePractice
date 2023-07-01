package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsSendKeysAndClick {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        By email = By.id("input-email");
        By password = By.id("input-password");
        By loginButton = By.xpath("//input[@value='Login']");


        //		Equivalent to calling: Actions.click(element).sendKeys(keysToSend).
//		This method is different from WebElement.sendKeys(CharSequence) -
//		see sendKeys(CharSequence) for details how.


//		Clicks in the middle of the given element.
//		Equivalent to: Actions.moveToElement(onElement).click()


        doLoginByActionsClassMethods(email,password,loginButton);

    }

    public static WebElement getElement(By locator){
       return driver.findElement(locator);
    }
    public static void doLoginByActionsClassMethods(By email, By password,By loginButton){

        Actions actions = new Actions(driver);
        // performing only build operation..and then storing it in a Action Interface.
        Action action = actions.sendKeys(getElement(email),"sahil.kumar9274@gmail.com").build();
        actions.sendKeys(getElement(password),"Sahil@765").perform();
        action.perform(); //performing it later
        actions.click(getElement(loginButton)).click().perform();

    }

}
