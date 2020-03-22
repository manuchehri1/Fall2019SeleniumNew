package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/gmail/");

        Thread.sleep(4000);

//        WebElement login = driver.findElement(By.name("a.h-c-header_nav-li-link"));
//
//        login.click();

        Thread.sleep(4000);
        WebElement username = driver.findElement(By.id("identifierId"));

        username.sendKeys("eco.lyceum.tj@gmail.com", Keys.ENTER);

        WebElement next1 = driver.findElement(By.name("RveJvd snByac"));
        next1.click();
        Thread.sleep(4000);
        WebElement password = driver.findElement(By.name("whsOnd zHQkBf"));
        //driver.findElement(By.className("whsOnd zHQkBf")).sendKeys("e1784172");

        password.sendKeys("e1784172",Keys.ENTER);
        WebElement next2 = driver.findElement(By.name("CwaK9"));

        next2.click();
        Thread.sleep(4000);

        driver.quit();


    }
}
