package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(4000);

        // By.name("q")----> name="q"  is one locator
        WebElement search = driver.findElement(By.name("q"));

        // once we found the element, how to enter txt?

        // to enter text use sendKeys() method
        // how to press enter after entering the text?
        // use Keys.ENTER
        search.sendKeys("Java", Keys.ENTER);

        Thread.sleep(4000);


        //if  see <a> elements, it calls links
        // visible this text of links can be used by selenium  to find this element

        WebElement news = driver.findElement(By.linkText("News"));


        // to click of it
        news.click();
        Thread.sleep(4000);

        driver.quit();







    }
}
