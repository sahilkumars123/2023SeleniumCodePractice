package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.Set;

public class WorkingWithComplexWindowHandlesOneByOne {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.dsetrucks.com.au/");

        String parentWindowId = driver.getWindowHandle();

        Thread.sleep(2000);

        By facebook = By.xpath("//a[contains(@href,'facebook')]");
        By twitter = By.xpath("//a[contains(@href,'twitter')]");
        By instagram =By.xpath("//a[contains(@href,'instagram')]");
        By linkedIn = By.xpath("//a[contains(@href,'linkedin')]");

        //for facebook
        clickAndGetSessionIdOneByOne(facebook,parentWindowId);
        System.out.println("DSE Portal URL is:: "+switchToParentWindow(parentWindowId));
        System.out.println("============================================");

        //for twitter
        clickAndGetSessionIdOneByOne(twitter,parentWindowId);
        System.out.println("DSE Portal URL is::"+switchToParentWindow(parentWindowId));
        System.out.println("============================================");

        //for instagram
        clickAndGetSessionIdOneByOne(instagram,parentWindowId);
        System.out.println("DSE Portal URL is::"+switchToParentWindow(parentWindowId));
        System.out.println("============================================");

        //for linkedIn
        clickAndGetSessionIdOneByOne(linkedIn,parentWindowId);
        System.out.println("DSE Portal URL is::"+switchToParentWindow(parentWindowId));
        System.out.println("============================================");

        driver.quit();
    }

    public static String switchToParentWindow(String parentWindowId){

        driver.switchTo().window(parentWindowId);
        return  driver.getCurrentUrl();
    }

    public static WebElement getElement(By locator){

       return driver.findElement(locator);
    }

    public static String getHref(By locator){
        return getElement(locator).getAttribute("href");
    }

    public static void clickAndGetSessionIdOneByOne(By locator, String parentWindowId){
         getElement(locator).click();
         String href = getHref(locator);
         Set<String> listOfOpenedWindows = driver.getWindowHandles();
         Iterator<String> it = listOfOpenedWindows.iterator();

         while (it.hasNext()){
             String currentSessionId = it.next();
             driver.switchTo().window(currentSessionId);
             if(!parentWindowId.equals(currentSessionId)) {
                 System.out.println("DSE "+href+" URL is:: " + driver.getCurrentUrl());
                 driver.close();
             }
         }
    }
}
