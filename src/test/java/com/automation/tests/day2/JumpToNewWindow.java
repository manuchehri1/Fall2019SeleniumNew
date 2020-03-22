package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws Exception{

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/open_new_tab");

        Thread.sleep(6000);

        //every window has some id, this id calls window handle
        // based on window handle, we can switch in between windows

        String windowHandle = driver.getWindowHandle();
        System.out.println("The window handle : "+windowHandle);

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("windowHandles = " + windowHandles);
        System.out.println("before switch = " + driver.getCurrentUrl());

        for (String windowId : windowHandles) {
            if (!windowId.equals(windowHandle)){
                driver.switchTo().window(windowId);
            }
        }

        System.out.println("after switch = " + driver.getCurrentUrl());

        Thread.sleep(3000);
        driver.close();

    }

}
