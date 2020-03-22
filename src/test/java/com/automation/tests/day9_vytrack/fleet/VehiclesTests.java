package com.automation.tests.day9_vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class VehiclesTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username ="storemanager85";
    private String password ="UserUser123";
    // https: - data is encrypted, no chance for hackers to retrieve or get info
    // http: - data as a plain test, very easy to hack it
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.xpath("//div[text()='Invalid user name or password.']");

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy =By.xpath("//h1[@class=\"oro-subtitle\"]");


    @Test (description = "Login as store manager and verify title is equal to Dashboard  ")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(actual,expected, "Page title is not correct");

    }
    /*TASK
under fleet package create a class called VehiclesPageTests
In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part. Use LoginPageTests class as a reference.
create a test called verifyPageSubTitle
    - in this test, you will need to navigate to Fleet --> Vehicles and verify that page subtitle is equals to "All Cars"
    user assertions for validation.

    * */
    @Test
    public void verifyPageSubTitle(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

//        driver.findElement(fleetBy).click();
        BrowserUtils.wait(5);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();

        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
        WebElement subTitleElement = driver.findElement(subtitleBy);
        System.out.println(subTitleElement.getText());
        String expected ="All Cars";
        String actual = subTitleElement.getText();

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void pageNumberTest(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

//        driver.findElement(fleetBy).click();
        BrowserUtils.wait(5);

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(fleetBy)).perform();

        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
        String expected ="1";
        String actual =driver.findElement(By.xpath("//input[@type=\"number\"]")).getAttribute("value");
        Assert.assertEquals(actual,expected);

    }










    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
