package com.automation.tests.My_Practice;

import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Safaripractice {
    public static void main(String[] args) {



        WebDriver driver = new SafariDriver();

        driver.get("http://google.com");
        BrowserUtils.wait(3);
        driver.quit();

    }


}
