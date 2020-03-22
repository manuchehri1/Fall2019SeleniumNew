package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class PracticeTests {
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

    @Test(description = "verify login")
    public void loginTest(){
        driver.findElement(By.xpath("//a[text()='Form Authentication']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtils.wait(3);
        String expected ="Welcome to the Secure Area. When you are done click logout below.";
        String actual=driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected, actual);
        driver.findElement(By.xpath("//i[text()=' Logout']")).click();
    }
    /* TASK for 5 minutes
 * Given user is on the practice landing page
 * When user navigates to "Forgot password" page
 * Then user enters his email
 * And clicks "Retrieve password" button
 * Then user verifies that message "Your e-mail's been sent!" is displayed
 */

    @Test
    public void forgetPasswordTest(){
        driver.findElement(By.xpath("//a[text()='Forgot Password']")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("manuchehri1@mail.ru");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//i[@class='icon-2x icon-signin']")).click();
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.tagName("h4")).getText();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkBoxesTest(){
        driver.findElement(By.xpath("//a[text()='Checkboxes']")).click();
        BrowserUtils.wait(3);
        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        checkBoxes.get(0).click();
//        WebElement checkbox1= driver.findElement(By.xpath("//input[@type='checkbox']"));
//        checkbox1.click();
        BrowserUtils.wait(3);
        Assert.assertTrue(checkBoxes.get(0).isSelected(), "Checkbox #1 is not selected");


    }



}
