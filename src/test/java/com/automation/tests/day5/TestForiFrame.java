package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(3);

        // before looking the textInput element, we need to jump to that frame
        driver.switchTo().frame("mce_0_ifr");
        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println("The text in the editor: "+textInput.getText());

        BrowserUtils.wait(3);
        textInput.clear();
        textInput.sendKeys("Hello Selenium");
        BrowserUtils.wait(3);

        //how to exit from this inner frame?
        driver.switchTo().defaultContent();

        driver.quit();

    }
}
