package com.automation.tests.Practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
    private String URL ="http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;

    @Test
    public void test1(){
        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Mike");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Tyson");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("mike123");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("mike1@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Mike.123");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("123-345-5454");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@value=\"male\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys("02/02/2002");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//select[@name=\"department\"]//option[1]")).click();
        BrowserUtils.wait(2);
//        Select departmentSelect = new Select(driver.findElement(By.name("department")));
//        departmentSelect.deselectByVisibleText("Department of Engineering");




        driver.findElement(By.xpath("//select[@name=\"job_title\"]//option[5]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@value=\"java\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        BrowserUtils.wait(4);
        String expected ="You've successfully completed registration!";
        String actual=driver.findElement(By.tagName("p")).getText();
        BrowserUtils.wait(4);
        Assert.assertEquals(actual,expected);

    }













    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        BrowserUtils.wait(3);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
