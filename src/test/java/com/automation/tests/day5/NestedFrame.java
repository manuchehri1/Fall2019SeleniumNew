package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(3);

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement content = driver.findElement(By.id("content"));
        System.out.println("Content of the inner frame : "+content.getText());

        driver.switchTo().parentFrame();// go to top frame back

        driver.switchTo().frame("frame-right");

        WebElement contentOfRightFrame = driver.findElement(By.tagName("body"));

        System.out.println("Content of the inner frame : "+contentOfRightFrame.getText());

        driver.switchTo().defaultContent();// go to top frame back

        driver.switchTo().frame("frame-bottom");
        WebElement contentOfBottomFrame = driver.findElement(By.tagName("body"));
        System.out.println("Content of the inner frame : "+contentOfBottomFrame.getText());



        driver.quit();

    }
}
