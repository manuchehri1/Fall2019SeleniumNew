package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        // create chromedriver

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.com");




    }



}
