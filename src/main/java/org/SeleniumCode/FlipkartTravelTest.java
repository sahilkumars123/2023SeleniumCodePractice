package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FlipkartTravelTest {

    static WebDriver driver;

    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.flipkart.com/travel/flights/search?trips=BOM-BLR-08072023&travellers=1-0-0&class=e&tripType=ONE_WAY&isIntl=false&source=Search%20Form");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        By listOfAllFlightPrices = By.xpath("//div[@class='_3uUoiD']");
      getChepeastFlight(listOfAllFlightPrices);
       // System.out.println(cheapestRate);

    }


    private static void getChepeastFlight(By listOfAllFlightPrices) {

        List<WebElement> flightPrice = driver.findElements(listOfAllFlightPrices);
//        int[] arr = new int[flightPrice.size()];
//        int k = 0;
        List<Integer> list = new ArrayList<>();
        for (WebElement e : flightPrice) {

            String text = e.getText();
            text = text.replaceAll("[^0-9]", "");
            list.add(Integer.parseInt(text));
        }
        Collections.sort(list);

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                int tmp = 0;
//                if (arr[i] > arr[j]) {
//                    tmp = arr[i];
//                    arr[i] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }
      //  return  arr[0];

        System.out.println(list.get(0));
    }
}
