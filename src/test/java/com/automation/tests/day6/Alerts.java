package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        
        buttons.get(0).click(); // to click on the first button
        BrowserUtils.wait(3);
        
        String popupText = driver.switchTo().alert().getText();
        System.out.println("popupText = " + popupText);
        driver.switchTo().alert().accept(); // to click OK

        String expected = "You successfuly clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();


        if (expected.equals(actual)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }


        buttons.get(1).click();
        BrowserUtils.wait(3);

        System.out.println();
        String popup2Text = driver.switchTo().alert().getText();
        System.out.println("popup2Text = " + popup2Text);
        driver.switchTo().alert().dismiss();// clicking on cancel

        BrowserUtils.wait(3);
        String expected2 ="You clicked: Cancel";
        String actual2 = driver.findElement(By.id("result")).getText();

        if (expected2.equals(actual2)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        System.out.println();
        BrowserUtils.wait(3);
        buttons.get(2).click();
        BrowserUtils.wait(3);
        String popup3Text = driver.switchTo().alert().getText();
        System.out.println("popup3Text = " + popup3Text);

       driver.switchTo().alert().sendKeys("Java");
        BrowserUtils.wait(2);
        driver.switchTo().alert().accept();

        String expected3 ="You entered: Java";
        BrowserUtils.wait(2);
        String actual3 =driver.findElement(By.id("result")).getText();

        if (expected3.equals(actual3)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }











        BrowserUtils.wait(3);
        driver.quit();
    }
}
