package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithWebTables {

    static WebDriver driver;

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://selectorshub.com/xpath-practice-page/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        clickCheckbox("Jordan.Mathews");
        clickCheckbox("Joe.Root");
        System.out.println(getEmployeeInfo("Joe.Root"));
    }

    public static void clickCheckbox(String empName){

        driver.findElement(By.xpath("//a[text()='"+empName+"']/ancestor::tr//input")).click();
    }

    public static List<String> getEmployeeInfo(String empName){

      List<WebElement> employeeInfo = driver.findElements(By.xpath("//a[text()='"+empName+"']/parent::td/following-sibling::td"));

      List<String> actualEmployeeInfo = new ArrayList<>();
      for(WebElement e : employeeInfo){
          String text = e.getText();
          actualEmployeeInfo.add(text);
      }
            return actualEmployeeInfo;
    }
}

