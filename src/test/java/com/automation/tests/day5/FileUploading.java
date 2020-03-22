package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploading {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(4);

        WebElement upload = driver.findElement(By.id("file-upload"));
        BrowserUtils.wait(3);


        String filePath = System.getProperty("user.dir")+"/pom.xml";
        String filePath2 ="/Users/user/IdeaProjects/Fall2019Selenium/pom.xml";

        String filePath3 = "/Users/user/Desktop/text.txt";

        upload.sendKeys(filePath3);


        driver.findElement(By.id("file-submit")).click();


        BrowserUtils.wait(4);



        driver.quit();
    }
}
