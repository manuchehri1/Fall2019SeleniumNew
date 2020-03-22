package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkboxes {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(3);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));


        for (int i=0; i<checkBoxes.size(); i++) {
            if (checkBoxes.get(i).isDisplayed()&& checkBoxes.get(i).isEnabled()&&  !checkBoxes.get(i).isSelected()){
                System.out.println(i+1+ " CheckBox is clicked");
                checkBoxes.get(i).click();
            }else {

                System.out.println(i+1+ " CheckBox is ALREADY clicked");
            }
            BrowserUtils.wait(2);
        }
//        checkBoxes.get(0).click();
//        BrowserUtils.wait(2);
//
//        checkBoxes.get(1).click();
//        BrowserUtils.wait(2);

        driver.quit();

    }
}
