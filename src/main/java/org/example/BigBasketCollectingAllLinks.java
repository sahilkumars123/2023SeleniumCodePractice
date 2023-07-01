package org.example;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BigBasketCollectingAllLinks {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.bigbasket.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        By level1locator = By.xpath("//a[@qa='categoryDD']");

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(level1locator)).perform();
        Thread.sleep(1500);

        ////ul[@class='dropdown-menu']//ul[@id='navBarMegaNav']/li
        List<WebElement> level1NavigationMenus = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']/li"));
        int level1NavigationMenusSize = level1NavigationMenus.size();

        ////ul[@id='navBarMegaNav']//following-sibling::div//div[@id='fruits-vegetables']//ul[contains(@class,'nav-stacked')]/li


        //int level2NavigationMenusSize = level2NavigationMenus.size();

        List<WebElement> level3NavigationMenus = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']//following-sibling::div//div[@id='fruits-vegetables']//ul[contains(@class,'nav-stacked')]//parent::div//following-sibling::div//li/a[@qa='catL3']"));
        int level3NavigationMenusSize = level3NavigationMenus.size();

        //List<String> idsofLevel1 = new ArrayList<>();
        for(WebElement e: level1NavigationMenus){
            System.out.println("===========================================");
            System.out.println(e.getText());
            String idOflevel1 = e.getAttribute("data-submenu-id");
            getSecondLevelOfMenus(idOflevel1);
            //idsofLevel1.add(idOflevel1);
        }
    }

    public static void getSecondLevelOfMenus(String al){

        List<WebElement> level2NavigationMenus = driver.findElements(By.xpath("//ul[@id='navBarMegaNav']//following-sibling::div//div[@id='"+al+"']//ul[contains(@class,'nav-stacked')]/li/a[@qa='catL2']"));

        for(WebElement e: level2NavigationMenus){
            System.out.println(e.getText());
        }
    }
}
