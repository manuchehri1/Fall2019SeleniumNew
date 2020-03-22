package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.sound.midi.Soundbank;
import java.util.List;

public class RegistrationForm {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/registration_form");

        BrowserUtils.wait(2);
        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Manuk");
        driver.findElement(By.name("lastname")).sendKeys("Mirzoev");
        driver.findElement(By.name("username")).sendKeys("manuchehri1");
        driver.findElement(By.name("email")).sendKeys("manuchehri1@mail.ru");
        driver.findElement(By.name("password")).sendKeys("M.manumehri1");
        driver.findElement(By.name("phone")).sendKeys("555-666-6666");

        List<WebElement> genders = driver.findElements(By.name("gender"));

        //select gender

        genders.get(1).click();

        driver.findElement(By.name("birthday")).sendKeys("01/01/2007");
        driver.findElement(By.id("inlineCheckbox2")).click();

        BrowserUtils.wait(3);
        driver.findElement(By.id("wooden_spoon")).click();

        BrowserUtils.wait(3);

        String singInMessage = driver.findElement(By.tagName("p")).getText();
        System.out.println(singInMessage);
        BrowserUtils.wait(3);
        driver.quit();




    }
}
