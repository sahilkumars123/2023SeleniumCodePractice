package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkingWithSelectClass {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.orangehrm.com/en/contact-sales/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        By countryDropDown = By.id("Form_getForm_Country");

        ElementUtil elementUtil = new ElementUtil(driver);

        //elementUtil.doSelectDropDownByValue(countryDropDown, "India");

        //elementUtil.doSelectDropDownByText(countryDropDown, "India");

        //elementUtil.doSelectDropDownByIndex(countryDropDown,5);

        //System.out.println(elementUtil.getCountOfAllDropDownValues(countryDropDown));

        //getDropDownTextList
//        List<String> actualDropDownValues = getDropDownTextList(countryDropDown);
//
//        List<String> expectedDropDownValues =  Arrays.asList("Sahil","Brazil","Austria"); //creating a collection
//
//        if(actualDropDownValues.containsAll(expectedDropDownValues)){
//
//            System.out.println("PASS");
//        }




    }

    public static List<WebElement> getElements(By locator){
        return driver.findElements(locator);
    }

    public List<String> doSelectDropDownValue(By locator){

        List<WebElement> dropDownTextList =  getElements(locator);
        List<String> optionsTextList = new ArrayList<>();
        for(WebElement e: dropDownTextList){
            String text = e.getText();
            System.out.println("Country:: "+text);
            optionsTextList.add(text);
        }
        return optionsTextList;
    }






}
