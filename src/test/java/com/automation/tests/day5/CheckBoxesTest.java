package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {
    public static void main(String[] args) {
        //WebDriver driver = DriverFactory.createDriver("chrome");

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        // verify that 1 st is not selected and 2nd is selected

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

        if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }
        System.out.println();
        BrowserUtils.wait(2);
        checkBoxes.get(0).click();
        if (checkBoxes.get(0).isSelected()){
            System.out.println("TEST PASSED");
            System.out.println("Checkbox #1 is selected");
        }else {
            System.out.println("TEST FAILED");
        }
        BrowserUtils.wait(2);
        driver.quit();
    }
}
