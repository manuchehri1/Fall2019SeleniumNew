package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests_teacher {
    private WebDriver driver;
    private Actions actions;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);
    }

    @Test
    public void hoverOnImage() {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));


        //build() is needed when you have couple of actions
        //always end with perform()
        // pause(1000). - like Thread.sleep(1000)
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();
        BrowserUtils.wait(3);
        //hover on the first image
        //verify that "name: user1" is displayed
        //hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        //move to the second image
        BrowserUtils.wait(3);
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//*[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

    }


    //hover on Enabled
    //hover on downloads
    // click on pdf
    @Test
    public void jqueryMenuTest(){
        driver.get("https://practice-cybertekschool.herokuapp.com/jqueryui/menu");
        WebElement enabledBtn = driver.findElement(By.id("ui-id-3"));
        WebElement downloadsBtn = driver.findElement(By.id("ui-id-4"));
        WebElement pdfBtn = driver.findElement(By.id(" ui-id-5"));
        actions.moveToElement(enabledBtn).
                pause(2000).
                moveToElement(downloadsBtn).
                pause(2000).
                click(pdfBtn).
                build().perform();



    }


    @AfterMethod
    public void teardown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}
