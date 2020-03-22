package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Warm_Up_My {
    /*
    WARM-UP
        Go to ebay
        enter search term
        click on search button
        print number of results
        go to amazon
        Go to ebay
        enter search term
        click on search button
        verify title contains search term
        Go to wikipedia.org
        enter search term `selenium webdriver`
        click on search button
        click on search result `Selenium (software)`
        verify url ends with `Selenium_(software)`

     */
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

    }
}
