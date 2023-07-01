package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/sahil.kumar/Documents/drivers/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");

        System.out.println(driver.getTitle());
        driver.close();
    }
}
