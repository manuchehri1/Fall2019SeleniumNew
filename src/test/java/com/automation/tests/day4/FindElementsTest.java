package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {

    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/");
        Thread.sleep(3000);

        // how to collect all links from the page?

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement eachLink : links) {
            System.out.println(eachLink.getText());
            System.out.println(eachLink.getAttribute("href"));
        }

        for (int i = 1; i <links.size();  i++) {
            links.get(i).click();

            driver.navigate().back();


            links = driver.findElements(By.tagName("a"));



        }


        driver.quit();

    }


}
