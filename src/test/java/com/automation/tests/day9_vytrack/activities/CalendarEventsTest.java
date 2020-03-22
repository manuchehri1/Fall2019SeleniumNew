package com.automation.tests.day9_vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CalendarEventsTest {
    private WebDriver driver;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private Actions actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By calendarEventBy = By.linkText("Calendar Events");
    private By createCalendarEventBy = By.xpath("//a[@title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu>a");
    private By currentOwnerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name=\"oro_calendar_event_form[title]\"]");
    private By startDateBy = By.cssSelector("[id*=\"date_selector_oro_calendar_event_form_start-u\"]");
    private By startTimeBy = By.cssSelector("[id*=\"time_selector_oro_calendar_event_form_start-ui\"]");


    private String username = "storemanager85";
    private String password = "UserUser123";




    @BeforeMethod
    public void setup () {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(2);


        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(3);
        driver.findElement(calendarEventBy).click();
        BrowserUtils.wait(3);
    }


    @Test
    public void createCalendarEventButton(){

        WebElement createCalendarEvent = driver.findElement(createCalendarEventBy);
        Assert.assertTrue(createCalendarEvent.isDisplayed());
    }

    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */

    @Test (description = "Default options")
    public void verifyDefaultValues(){
        driver.findElement(createCalendarEventBy).click();
        BrowserUtils.wait(3);

        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        System.out.println("currentUserName = " + currentUserName);
        String defaultOwnerName =driver.findElement(currentOwnerBy).getText().trim();
        System.out.println("defaultOwnerName = " + defaultOwnerName);

         WebElement titleElement = driver.findElement(titleBy);
        Assert.assertEquals(currentUserName,defaultOwnerName);
        BrowserUtils.wait(3);
        //Default title should be blank
        Assert.assertTrue(titleElement.getAttribute("value").length()==0);
        BrowserUtils.wait(3);

        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate,expectedDate);

        //Default start time should be current time
        //String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime,expectedTime);



        




    }




    @AfterMethod
    public void teardown(){
        driver.quit();
    }




}
