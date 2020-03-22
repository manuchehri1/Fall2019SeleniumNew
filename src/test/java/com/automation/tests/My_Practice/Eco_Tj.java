package com.automation.tests.My_Practice;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Eco_Tj {
    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("https://eco.tj/");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys();




    }
}
