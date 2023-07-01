package org.SeleniumCode;

import CustomException.FrameWorkException;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ElementUtil {

    private WebDriver driver;
    private Actions act;

    public ElementUtil(WebDriver driver){

        this.driver = driver;
        act = new Actions(driver);
    }

    public void doSendKeys(By locator, String value){
        if(value == null){
            throw new FrameWorkException("VALUECANNOTBENULL");
        }
       getElement(locator).sendKeys(value);
    }

    public boolean isElementEnabled(By locator){
        String flag = getElement(locator).getAttribute("disabled");
        if (flag.contains("true")){
            return true;
        }
        else
            return false;
    }

    public  void doClick(By locator){
        getElement(locator).click();
    }

    public String doElementGetText(By locator) {
        String eleText = getElement(locator).getText();
        System.out.println("Element text is ====>" + eleText);
        return eleText;
    }

    public WebElement getLinkEleByText(String text){
        return driver.findElement(By.linkText(text));
    }
    public boolean checkElementIsDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }
    public String getElementAttribute(By locator, String attributeName){

        return getElement(locator).getAttribute(attributeName);
    }
    public WebElement getElement(By locator){
       return driver.findElement(locator);
    }

    public List<WebElement> getElements(By locator){

      return driver.findElements(locator);
    }

    public void clickOnElementByTakingList(By locator, String linkText){
        List<WebElement> langLinks = getElements(locator);
        System.out.println("Total number of links :: "+langLinks.size());
        for(WebElement e : langLinks){
            String text = e.getText();
            System.out.println(text);
            if(text.equals(linkText)){
                e.click();
                break;
            }
        }
    }

    public void doSearch(By searchLocator, By searchSuggLocator, String searchKey, String suggName) throws InterruptedException {
        getElement(searchLocator).sendKeys(searchKey);

        Thread.sleep(4000);

        List<WebElement> suggestionList = getElements(searchSuggLocator);

        for (WebElement e : suggestionList) {
            String text = e.getText();
            System.out.println(text);
            if (text.contains(suggName)) {
                e.click();
                break;
            }
        }
    }

        //******** Drop Down Utility Methods *********//
    public void selectDropDownByVisibleText(By locator, String searchText){
        WebElement countryDropDownList = getElement(locator);
        Select select = new Select(countryDropDownList);
        select.selectByVisibleText(searchText);
    }

    public void selectDropDownByVisibleValue(By locator, String searchTextValue){
        WebElement countryDropDownList = getElement(locator);
        Select select = new Select(countryDropDownList);
        select.selectByValue(searchTextValue);
    }

    public void selectDropDownByIndex(By locator, int index){
        if(index < 0){
            System.out.println("please pass the (+ve) index");
            return;
        }
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public void doSelectDropDownByIndex(By locator, int index){
        if(index < 0){
            System.out.println("please pass the (+ve) index");
            return;
        }
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public void doSelectDropDownByValue(By locator, String value){
       if(value == null){
           System.out.println("please pass the right visible text and it can not be null");
           return;
       }
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    public void doSelectDropDownByText(By locator, String searchText){
        if(searchText == null){
            System.out.println("please pass the right visible text and it can not be null");
            return;
        }
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(searchText);
    }

    public  int getCountOfAllDropDownValues(By locator){
        Select select = new Select(getElement(locator));
        return select.getOptions().size();
    }

    public  List<String> getDropDownTextList(By locator){
        Select select = new Select(getElement(locator));
        List<WebElement> optionsList = select.getOptions();
        List<String> optionsTextList = new ArrayList<>();

        for (WebElement e: optionsList){
            String text = e.getText();
            System.out.println(text);
            optionsTextList.add(text);
        }
        return optionsTextList;
    }

    public void doSelectDropDownValue(By locator, String dropDownValue) {
        Select select = new Select(getElement(locator));
        List<WebElement> optionsList = select.getOptions();

        for(WebElement e : optionsList) {
            String text = e.getText();
            System.out.println(text);
            if(text.equals(dropDownValue)) {
                e.click();
                break;
            }
        }
    }

    public void doSelectDropDownValueUsingLocator(By locator, String dropDownValue) {
        List<WebElement> optionsList = getElements(locator);
        for(WebElement e : optionsList) {
            String text = e.getText();
            System.out.println(text);
            if(text.equals(dropDownValue)) {
                e.click();
                break;
            }
        }
    }

    public List<String> printAttributeValue(By locator, String attrName){

        List<WebElement> getListOfAllDropDownValues = getElements(locator);
        List<String> actualAttributeValue = new ArrayList<>();

        for(WebElement e: getListOfAllDropDownValues){
            String text = e.getAttribute(attrName);
            System.out.println(text);
            actualAttributeValue.add(text);
        }
        return actualAttributeValue;
    }

    TakesScreenshot ts;

    //******* Actions Utils ***************//
    public void doActionsClick(By locator) {
        act.click(getElement(locator)).perform();
    }

    public void doActionsSendKeys(By locator, String value) {
        act.sendKeys(getElement(locator), value).perform();
    }

    public void selectRightClickOption(By contextMenuLocator, String optionValue) {
        Actions act = new Actions(driver);
        act.contextClick(getElement(contextMenuLocator)).perform();
        By optionLocator = By.xpath("//*[text()='" + optionValue + "']");
        doClick(optionLocator);
    }

    /**
     * this method will handle the menu upto two levels
     * @param level1MenuLocator
     * @param level2MenuLocator
     * @throws InterruptedException
     */
    public void multiLevelMenuHandling(By level1MenuLocator, By level2MenuLocator) throws InterruptedException {
        act.moveToElement(getElement(level1MenuLocator)).perform();
        Thread.sleep(1500);
        doClick(level2MenuLocator);
    }
    public void multiLevelMenuHandling(By level1Locator, String level2, String level3, String level4) throws InterruptedException {
        act.moveToElement(getElement(level1Locator)).perform();
        Thread.sleep(1500);
        act.moveToElement(getLinkEleByText(level2)).perform();
        Thread.sleep(1500);
        act.moveToElement(getLinkEleByText(level3)).perform();
        Thread.sleep(1500);
        getLinkEleByText(level4).click();
    }

    public void multiLevelMenuHandling(By level1Locator, String level2, String level3) throws InterruptedException {
        act.moveToElement(getElement(level1Locator)).perform();
        Thread.sleep(1500);
        act.moveToElement(getLinkEleByText(level2)).perform();
        Thread.sleep(1500);
        getLinkEleByText(level3).click();
    }

    //**************ElementUtil*************************//
    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible.
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementPresence(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     *  Visibility means that the element is not only displayed
     *  but also has a height and width that is greater than 0.
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForElementVisible(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

}

