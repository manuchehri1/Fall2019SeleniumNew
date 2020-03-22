package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultipalOptions {

    public static void main(String[] args) {
        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        Boolean isMultiple=languagesSelect.isMultiple(); // will be true if there are multiple options
        System.out.println(isMultiple);

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for (WebElement eachSelectedLanguage : selectedLanguages) {
            System.out.println(eachSelectedLanguage.getText());
        }
        BrowserUtils.wait(3);

        languagesSelect.deselectByVisibleText("Python");



        BrowserUtils.wait(3);
        driver.quit();
    }

}
