package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    private RemoteWebDriver driver;


    @BeforeMethod
    public void setup(){
//        driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


    @Test
    public void scrollTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com/infinite_scroll");
    //    JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down by 250 pixels
        // x, y
        BrowserUtils.wait(3);

        driver.executeScript("window.scrollBy(0, 250)");
        BrowserUtils.wait(3);
        driver.executeScript("window.scrollBy(0, -250)");
        for (int i = 0; i < 10 ; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(2);
        }
        BrowserUtils.wait(3);

    }

    @Test
    public void scrollToElementTest(){
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);
        WebElement link =  driver.findElement(By.linkText("Cybertek School"));

        // scroll util link will be visible
        driver.executeScript("arguments[0].scrollIntoView(true)",link);
        BrowserUtils.wait(3);
    }

}
