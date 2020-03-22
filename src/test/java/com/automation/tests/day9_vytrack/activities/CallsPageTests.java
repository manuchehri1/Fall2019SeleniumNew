package com.automation.tests.day9_vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTests {

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private WebDriver driver;
    private Actions actions;


    private String username = "storemanager85";
    private String password = "UserUser123";
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBy = By.xpath("//a[@title='Log call']");



    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);

        BrowserUtils.wait(3);

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(3);

        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(3);
    }

    @Test
    public void verifyLogCallButton(){
        Assert.assertTrue(driver.findElement(logCallBy).isDisplayed(),"Log Call button is not displayed");

    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }







}
