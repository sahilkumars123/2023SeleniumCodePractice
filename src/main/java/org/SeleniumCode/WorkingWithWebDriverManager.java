package org.SeleniumCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class WorkingWithWebDriverManager {

    public static void main(String[] args) {
        String desiredVersion = "92.0.4515.107";

       WebDriver driver = WebDriverManager.chromedriver().browserVersion(desiredVersion).create();
       driver.get("https://www.google.com");
       System.out.println(driver.getTitle());
       System.out.println(driver.getCurrentUrl());
       driver.quit();

    }
}
