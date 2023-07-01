//package org.example;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.Iterator;
//import java.util.Set;
//
//public class WorkingWithComplexWindowHandlesOneByOneNeelam {
//
//    static WebDriver driver;
//
//    public static void main(String[] args) throws InterruptedException {
//
//        driver = new ChromeDriver();
//        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"); // browser window1
//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();// twitter window
//        Thread.sleep(5000);
////1. fetching the window id's for switching work
//        Set<String> handles = driver.getWindowHandles();
//
//        Iterator<String> it = handles.iterator();
//
//        String parentWindowId = it.next();
//        System.out.println("parent window id: "+parentWindowId);
//
//        String twtrWindowId = it.next();
//        System.out.println("Twitter window id: "+twtrWindowId);
//
////switch work
//        driver.switchTo().window(twtrWindowId);
//        System.out.println("Twitter window URL: "+driver.getCurrentUrl());
//
////close the child window:
//        driver.close();
//
////come back to parent window:
//        driver.switchTo().window(parentWindowId);
//        System.out.println("parent window URL: "+driver.getCurrentUrl());
//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();// fb window
//        Thread.sleep(5000);
//
//        String fbWindowId = it.next();
//        System.out.println("Facebook Window ID: "+fbWindowId);
//
//        driver.switchTo().window(fbWindowId);
//        System.out.println("Facebook window URL: "+driver.getCurrentUrl());
//        driver.close();
//
////come back to parent window:
//        driver.switchTo().window(parentWindowId);
//        System.out.println("parent window url: "+driver.getCurrentUrl());
//    }
//}
