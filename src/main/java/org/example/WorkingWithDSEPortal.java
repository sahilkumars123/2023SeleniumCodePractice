package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithDSEPortal {


    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/sahil.kumar/Documents/drivers/chromedriver");

        BrowserUtil brUtil = new BrowserUtil();
        driver = brUtil.intializeBrowser("chrome");
        brUtil.launchURL("https://stagingadmin.dsetrucks.com.au/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

        By emailID = By.name("email");
        By password = By.name("password");
        By signInButton = By.xpath("//form[@id='login']//button[text()='Sign In']");
        By burgerIcon = By.xpath("//a[@role='button']");
        By navBarElements = By.xpath("//ul[@class='sidebar-menu']/li");
        By jobsList = By.xpath("//li[@class='treeview active']/ul[contains(@class,'menu-open')]/li");
        By jobListPageTitle = By.xpath("//h3[contains(text(),'Job List')]");

        ElementUtil elementUtil = new ElementUtil(driver);
        elementUtil.doSendKeys(emailID,"shikha.koul@prajal.com");
        elementUtil.doSendKeys(password,"1234DSE5679");
        elementUtil.doClick(signInButton);
        elementUtil.doClick(burgerIcon);
        elementUtil.clickOnElementByTakingList(navBarElements,"Jobs");
        elementUtil.clickOnElementByTakingList(jobsList,"Job List");
        String actualHeaderText = elementUtil.doElementGetText(jobListPageTitle);
        String expectedHeaderText = "Job List";
        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Reched Destination");
        }
        else {
            System.out.println("Something went wrong in middle...");
        }

        Select select = new Select(driver.findElement(By.name("job-table_length")));
        select.selectByVisibleText("10");

        List<String> customerAndDriverName = getDriverAndCustomerName("AA0894");
        System.out.println("Customer and Driver Name:: "+customerAndDriverName);
        driver.quit();
    }

    public static List<String> getDriverAndCustomerName(String jobID){

       By jobIdXpath = By.xpath("//a[text()='"+jobID+"']/parent::td//following-sibling::td/a");

        List<WebElement> list = driver.findElements(jobIdXpath);
        List<String> al = new ArrayList<>();
        for (WebElement e: list){
            al.add(e.getText());
        }
        return al;
    }

}
