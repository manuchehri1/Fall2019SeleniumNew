package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://hi5.com");
        driver.navigate().refresh();
        BrowserUtils.wait(3);

       driver.findElement(By.id("username")).sendKeys("manuchehri1@mail.ru");


        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("e1784172");
        password.click();
        BrowserUtils.wait(2);
        driver.findElement(By.id("nav_account")).click();
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//*[@id=\"navheader\"]/div/div/ul/li[3]/div/ul/li[11]/a")).click();



        BrowserUtils.wait(3);
        driver.quit();

    }
}
