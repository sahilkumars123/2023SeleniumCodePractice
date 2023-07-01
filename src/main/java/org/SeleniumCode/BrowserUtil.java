package org.SeleniumCode;

import CustomException.FrameWorkException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserUtil {

    private WebDriver driver;

    public WebDriver intializeBrowser(String browserName) {

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                // code block
                break;
            default:
                System.out.println("Please enter valid browser name");

        }
        return driver;
    }

    public void launchURL(String url) {

        if (url.contains("http"))
            driver.get(url);
        else
            throw new FrameWorkException("INVALIDVALUE");
    }
    public String getTitle(){

       return driver.getTitle();
    }

    public void closeBrowser(){
        driver.close();
    }
    public void quitBrowser(){
        driver.quit();
    }
}
