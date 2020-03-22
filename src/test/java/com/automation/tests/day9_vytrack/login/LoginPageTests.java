package com.automation.tests.day9_vytrack.login;


import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private String username ="storemanager85";
    private String password ="UserUser123";
    // https: - data is encrypted, no chance for hackers to retrieve or get info
    // http: - data as a plain test, very easy to hack it
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.xpath("//div[text()='Invalid user name or password.']");

    @Test (description = "verify warning message appears when user enters invalid username ")
    public void invalidUsername(){
        driver.findElement(usernameBy).sendKeys("invaliusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        String expected ="Invalid user name or password.";
        String actual =driver.findElement(warningMessageBy).getText();

//        WebElement waningElement =driver.findElement(warningMessageBy);
//        assertTrue(waningElement.isDisplayed());
        assertEquals(expected,actual);
    }

    @Test (description = "Login as store manager and verify title is equal to Dashboard  ")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        String expected = "Dashboard";
        String actual = driver.getTitle();

        assertEquals(actual,expected, "Page title is not correct");

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
