package com.automation.tests.My_Practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class Practice {
     private WebDriver driver;

    @BeforeMethod
    public void setup(){
        //setup webdriver
        WebDriverManager.chromedriver().version("79").setup();


        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        BrowserUtils.wait(3);
    }
    @AfterMethod
    public void teardown(){
        //close browser and destroy webdriver object
        driver.quit();
    }

    @Test
    public void addTest(){
        System.out.println("Test1");
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        List<WebElement> addedElements  = driver.findElements(By.xpath("//button[@class='added-manually']"));
        Assert.assertTrue(!addedElements.isEmpty(),"Element is not added");

    }
    @Test
    public void removeElement(){
        System.out.println("Test2");
        driver.findElement(By.xpath("//a[text()='Add/Remove Elements']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@class='added-manually'][1]")).click();
        BrowserUtils.wait(3);
        List<WebElement> addedElements  = driver.findElements(By.xpath("//button[@class='added-manually']"));
        Assert.assertTrue(addedElements.isEmpty(),"Element is not removed");
    }

    @Test
    public void autocompleteTest(){
        System.out.println("Test3");
        driver.findElement(By.xpath("//a[text()='Autocomplete']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.id("myCountry")).sendKeys("Tajikistan");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@onclick='log()']")).click();
        BrowserUtils.wait(3);
        String expected = "You selected: Tajikistan";
        String actual =driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expected,actual);

    }
    @Test
    public void basicAuthTest(){
        driver.findElement(By.xpath("//a[text()='Basic Auth']")).click();
        BrowserUtils.wait(3);
        Alert alert = driver.switchTo().alert();

    }


}
