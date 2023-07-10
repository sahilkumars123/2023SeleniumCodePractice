package org.SeleniumCode;

import CustomException.FrameWorkException;
import com.beust.ah.A;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlipkartTravelTest {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.noon.com/uae-en/");

        By ProductName = By.xpath("//h2[text()='Recommended for you']/ ../ ..//following-sibling::div//a[contains(@id,'productBox')]//div[@data-qa='product-name']");

        List<String> products =  getProductName(ProductName);
        System.out.println(products);

//        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//        Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
//        alert.accept();

//         driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys("SahilAutomation");
//        alert.accept();
//
//        String text = driver.findElement(By.id("result")).getText();
//        String result = text.split(":")[1].trim();
//        System.out.println(result);

//        By button = By.xpath("//span[text()='right click me']");
//        clickOnContextMenuOptions(button,"Copy");
//
//       Alert alert = driver.switchTo().alert();
//        System.out.println(alert.getText());
//       alert.accept();
    }

    private static List<String> getProductName(By locator){

      List<WebElement> productNames =  getElements(locator);
        System.out.println("List contains "+productNames.size()+" elements");

        List<String> productList = new ArrayList<>();

        for(WebElement product : productNames){
            String text = product.getText();
            if(!text.isEmpty()){
                productList.add(text);
            }
        }
        return productList;
    }



    private static void clickOnContextMenuOptions(By locator,String value){
        Actions actions = new Actions(driver);
        actions.contextClick(getElement(locator)).perform();

       List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'context-menu-root')]/li[contains(@class,'context-menu-icon')]"));

       for(WebElement e: options){
           String text = e.getText();
           if(text.equals(value)){
               e.click();
               break;
           }
       }
    }



    private static void selectCountryWithoutUsingSelectClass(By locator,String country){

        List<WebElement> countries = getElements(locator);
        boolean flag = false;
        for(WebElement e: countries){
            String text = e.getText();
            if(text.equals(country)){
                e.click();
                flag = true;
                break;
            }
        }
        if(!flag){
            System.out.println("Sorry! could not found the country:: "+country);
        }
    }


    private static void selectCountryOnBasisOfIndex(By locator, int index){

        if(index < 0){
            System.out.println("index should be in +ve number");
        }
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }
    private static void selectCountryOnBasisOfValue(By locator, String value){

        if(value == null){
            System.out.println("please pass the right value, value cannot be null");
        }
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }
    private static void selectCountryOnBasisOfVisibleText(By locator, String text){

        if(text == null){
            System.out.println("please pass the right text, text cannot be null");
        }
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(text);
    }




    private static List<String> getAllCountries(By locator) {
        Select select = new Select(getElement(locator));
        List<WebElement> countriesList = select.getOptions();
        List<String> countryList = new ArrayList<>();

        for(WebElement country : countriesList){
            String text = country.getText();
            if(!text.isEmpty()){
                countryList.add(text);
            }
        }
        return countryList;
    }


    private static List<String> getPlayerInfo(String playerName){

        By playerInfoXpath = By.xpath("//span[text()='"+playerName+"']//ancestor::a/parent::td/following-sibling::td/span[contains(@class,'ds-items-center')]");

         List<WebElement> playerInfo = driver.findElements(playerInfoXpath);
         List<String> playerInningsRecord = new ArrayList<>();

        for(WebElement e: playerInfo){
            String text = e.getText();
            if(!text.isEmpty()){
                playerInningsRecord.add(text);
            }
        }
        return playerInningsRecord;
    }

    private static void clickOnLang(String language) {

        boolean flag = false;

        By langLinks = By.xpath("//div[@id='SIvCob']/a");

             List<WebElement> languages = driver.findElements(langLinks);

             for(WebElement e: languages){
                 String text = e.getText();
                 if(text.equals(language)){
                     e.click();
                     flag = true;
                     break;
                 }
             }
             if(!flag){
                 System.out.println("please enter correct language");
             }
    }

    public static void clickEmployee(String employeeName){

        By employeeCheckbox = By.xpath("//a[text()='"+employeeName+"']//ancestor::tr/td/input[@type='checkbox']");
        driver.findElement(employeeCheckbox).click();
    }







    public static void getAllImages(By locator){

        List<WebElement> imagesList =   driver.findElements(locator);

        for(WebElement e: imagesList){
         String src =   e.getAttribute("src");
         String alt =   e.getAttribute("alt");
            System.out.println(src+":"+alt);
        }


    }

    public static List<String> getAllLinks(By locator){

       List<WebElement> allLinks = driver.findElements(locator);
        System.out.println("count of all links is:: "+getCountOfAllLinks(locator));
       List<String> links = new ArrayList<>();
        for(WebElement e: allLinks){
            String text = e.getText();
            if(!text.isEmpty()){
                links.add(text);
            }
        }
        return links;
    }

    public static List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public static int getCountOfAllLinks(By locator){
       return driver.findElements(locator).size();
    }


    public static String getElementAttribute(By locator, String attributeName){

       return driver.findElement(locator).getAttribute(attributeName);

    }


    public static boolean checkElementDisabled(By registerText){

          if(getElement(registerText).isDisplayed()){
              return true;
          }
          else {
              return false;
          }
    }


    public static String getElementText(By locator){

       return driver.findElement(locator).getText();
    }

    public static WebElement getElement(By locator){
            WebElement element = null;
            try {
               return driver.findElement(locator);
            }
            catch (NoSuchElementException e){
                System.out.println("Element is not visible");
                throw new FrameWorkException("ELEMENTNOTVISIBLE");
            }
    }


}


