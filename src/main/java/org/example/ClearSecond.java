package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ClearSecond {

   static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.findElement(By.xpath("//input[@type='text' and contains(@class,'VJZDxU')]")).sendKeys("9876778283");
        driver.findElement(By.xpath("//button[text()='Request OTP']")).click();

        driver.close();
    }
}


//    private static  void getChepeastFlightRate(By listOfAllFlightRatesInFlipkart) {
//
//        List<WebElement> listOfAllFlight = driver.findElements(listOfAllFlightRatesInFlipkart);
//
//        int sizeOfFlightsList = listOfAllFlight.size();
//
//        for(WebElement e : listOfAllFlight){
//
//         //   if()
//
//        }

