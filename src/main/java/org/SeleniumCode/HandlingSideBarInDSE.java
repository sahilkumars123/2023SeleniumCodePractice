package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class HandlingSideBarInDSE {

   public static WebDriver driver;

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

        List<WebElement> sidebarMenus = driver.findElements(By.xpath("//ul[@class='sidebar-menu']/li"));
        Actions actions = new Actions(driver);

        int size = sidebarMenus.size();
        int i=1;
        for(WebElement e: sidebarMenus){
                actions.moveToElement(e).perform();
                System.out.println("====================================");
                Thread.sleep(1000);
                if(i<=size) {
                    printLeftMenu(i);
                    i++;
                }
        }
        driver.quit();

    }

    public static void printLeftMenu(int i){

         String path = String.format("(//ul[@class='sidebar-menu']/li)[%d]/ul/li",i);
         List<WebElement> list = driver.findElements(By.xpath(path));
         for (WebElement e: list){
             System.out.println(e.getText());
         }
    }
}
