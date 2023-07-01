package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class Clear {

   static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/sahil.kumar/Documents/drivers/chromedriver");
        driver = new ChromeDriver();
        //driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.flipkart.com/travel/flights/search?trips=BOM-BLR-07072023&travellers=1-0-0&class=e&tripType=ONE_WAY&isIntl=false&source=Search%20Form");
        By listOfAllFlightRates = By.xpath("(//div[@id='container']//div[contains(@class,'_1YokD2 _3Mn1Gg col-9-12')]//div[@class='row']//div[@class='col-12-12'][last()])/div//div[@class='_3uUoiD']");
        getChepeastFlightRate(listOfAllFlightRates);
    }


    private static  void getChepeastFlightRate(By listOfAllFlightRatesInFlipkart) {

        List<WebElement> listOfAllFlight = driver.findElements(listOfAllFlightRatesInFlipkart);
//        int sizeOfFlightsList = listOfAllFlight.size();
        int lowestPrice  = 0;
        int curentFlightPrice = Integer.MAX_VALUE;

        Actions actions = new Actions(driver);

        for(WebElement e : listOfAllFlight){

           String flightRate = e.getText();
           flightRate = flightRate.replaceAll("[^0-9]","");
             int flightPrice = Integer.parseInt(flightRate);
             if(flightPrice < curentFlightPrice){
                     lowestPrice = flightPrice;
                     curentFlightPrice = lowestPrice;
             }
//            actions.moveToElement(e).build().perform();
//            System.out.println(e.getText());
        }
        System.out.println(lowestPrice);
    }
}
