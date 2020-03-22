package com.automation.tests.day9_vytrack.activities;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActivitiesTest {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username ="storemanager85";
    private String password ="UserUser123";
    // https: - data is encrypted, no chance for hackers to retrieve or get info
    // http: - data as a plain test, very easy to hack it
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.xpath("//div[text()='Invalid user name or password.']");


    @Test
    public void verifyCalls(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        Actions actions = new Actions(driver);



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
