package com.automation.tests.Warm_Up;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.Arrays;

public class March04 {
    public static void main(String[] args) throws Exception {

//        WARM-UP
//        Go to ebay
//        enter search term
//        click on search button
//        print number of results
//        go to amazon
//        Go to ebay
//        enter search term
//        click on search button
//        verify title contains search term
//        Go to wikipedia.org
//        enter search term `selenium webdriver`
//        click on search button
//        click on search result `Selenium (software)`
//        verify url ends with `Selenium_(software)`

        ebayTest();
        amazonTest();
        wikiTest();
    }
    static  WebDriver driver;

    public static void ebayTest(){

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();

        WebElement searchResult = driver.findElement(By.tagName("h1"));

        String [] search = searchResult.getText().split(" ");
        System.out.println(Arrays.toString(search));
        System.out.println("Search result : "+search[0]);

        driver.quit();
    }
    public static void amazonTest(){
        driver = DriverFactory.createDriver("chrome");

        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("java book", Keys.ENTER);

        String title = driver.getTitle();
        if (title.contains("java book")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        driver.quit();
    }
    public static void wikiTest() throws Exception{
        driver = DriverFactory.createDriver("chrome");

        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        driver.findElement(By.id("searchInput")).sendKeys("Selenium web", Keys.ENTER);

        driver.findElement(By.partialLinkText("Selenium webdriver")).click();

        Thread.sleep(3000);

        String link =driver.getCurrentUrl();

        if (link.endsWith("Selenium_(software)")){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

    }
}
