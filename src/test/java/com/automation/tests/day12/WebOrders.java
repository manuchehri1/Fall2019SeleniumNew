package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){

        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2ftestcomplete12%2fweborders%2fDefault.aspx");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test",Keys.ENTER);

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

    @Test
    public void verifyCheckBoxes(){
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        BrowserUtils.wait(5);
        List<WebElement> checkBoxElements = driver.findElements(By.xpath("//*[@type='checkbox']"));
        for (WebElement checkBoxElement : checkBoxElements) {
            Assert.assertTrue(checkBoxElement.isSelected());
        }
    }

    /**
     * go to web orders page
     * verify that Steve Johns zip code is 21233
     * Then update his ip code to 20002
     * Then verify that zip code is 20002
     */

    @Test(description = "verify zip code")
    public void test2( ){

        String expected1 = "21233";
        //WebElement zipcode = driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        WebElement zipCode = driver.findElement(By.xpath("//*[text()='21233']"));
        String actual1 = zipCode.getText();
        Assert.assertEquals(actual1,expected1);
        BrowserUtils.wait(3);

        //driver.findElement(By.xpath(" //td[text()='Steve Johns']//following-sibling::td/input")).click();
        driver.findElement(By.xpath("(//input[@type=\"image\"])[3]")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("20002");
        BrowserUtils.wait(3);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        BrowserUtils.wait(3);

        WebElement zipCode2 = driver.findElement(By.xpath("//*[text()='20002']"));

        String expected2 = "20002";
        String actual2 = zipCode2.getText();
        Assert.assertEquals(actual2,expected2);


    }
    /*
    * Go to webpage
    * go to order and order a screensaver product
    * verify that your order is in the list of All orders
    *
    *
    *
    * */
    @Test(description = "verify the ordered product")
    public void test3(){
        driver.findElement(By.xpath("//a[text()='Order']")).click();
        BrowserUtils.wait(2);

        WebElement productSelection = driver.findElement(By.id("id=\"ctl00_MainContent_fmwOrder_ddlProduct\""));

        Select selectProduct = new Select(productSelection);

        selectProduct.selectByVisibleText("ScreenSaver");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys("2");

        driver.findElement(By.cssSelector("[value=\"Calculate\"]")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Mesut Ali");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("375 Shore Pkwy");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Brooklyn");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("NY");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("10001");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("123456789");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("03/30");

        BrowserUtils.wait(5);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
















    }




}
