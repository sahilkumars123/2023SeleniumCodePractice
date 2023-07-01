package org.SeleniumCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class cricInfo {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://www.espncricinfo.com/series/afghanistan-in-sri-lanka-2023-1376998/sri-lanka-vs-afghanistan-3rd-odi-1377010/full-scorecard");

        String actualWcktTakerName =  getWktTakerName("Ibrahim Zadran");

        System.out.println(actualWcktTakerName);

        List<String> stats = getBatsmanStats("Ibrahim Zadran");

        System.out.println("Batsman stats:: "+stats);

        driver.quit();

    }

    public static String getWktTakerName(String batsman){

        System.out.println("Batsman name:: "+batsman);

        String bowlerName = driver.findElement(By.xpath("//span[text()='"+batsman+"']/ancestor::td/following-sibling::td/span")).getText();

        return bowlerName;
    }

    public static List<String> getBatsmanStats(String batsman){

       List<WebElement> bastmanStats = driver.findElements(By.xpath("//span[text()='"+batsman+"']/ancestor::td/following-sibling::td"));
       List<String> actualStats = new ArrayList<>();
       for (int i=1; i<bastmanStats.size(); i++){
           String text = bastmanStats.get(i).getText();
           if(!text.isEmpty())
                actualStats.add(bastmanStats.get(i).getText());
       }
       return actualStats;
    }
}
