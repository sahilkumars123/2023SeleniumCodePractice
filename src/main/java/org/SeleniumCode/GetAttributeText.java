package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GetAttributeText {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        //  ChromeDriver driver = new ChromeDriver();
        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("http://seleniumpractise.blogspot.com/2016/09/how-to-work-with-disable-textbox-or.html");

        By first_name = By.id("fname");


        ElementUtil elementUtil = new ElementUtil(driver);
        String fname_type = elementUtil.getElementAttribute(first_name,"type");
        System.out.println(fname_type);

    }



}
