package com.automation.tests.homeworks.homework3;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.*;

public class RegistrationFormTests {
    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com/";
    private String tempURL = "https://www.fakemail.net/";
    private By registrationFormBy = By.xpath("//*[text()='Registration Form']");
    private By fileUploadBy = By.xpath("//*[text()='File Upload']");




    //Step 3. Enter “wrong_dob” into date of birth input box.Step
    // 4. Verify that warning message is displayed:
    // “The date of birth is not valid”
    @Test
    public void test1(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(5);

        driver.findElement(registrationFormBy).click();
        BrowserUtils.wait(3);

        driver.findElement(By.name("birthday")).sendKeys("wrong_dob");
        BrowserUtils.wait(3);

        WebElement message = driver.findElement(By.xpath("//small[contains(text(),'is not valid')]"));
        assertTrue(message.isDisplayed());

    }


    //Verify that following options for programming
    // languages are displayed: c++, java, JavaScript
    @Test
    public void test2(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(registrationFormBy).click();
        BrowserUtils.wait(3);

        WebElement cPlus = driver.findElement(By.xpath("//*[text()='C++']"));
        WebElement java = driver.findElement(By.xpath("//*[text()='Java']"));
        WebElement javaScript = driver.findElement(By.xpath("//*[text()='JavaScript']"));

        List<WebElement> languages = Arrays.asList(cPlus,java,javaScript);
        for (WebElement language : languages) {
            assertTrue(language.isDisplayed());
        }

    }
    //Step 3. Enter only one alphabetic character into first name input box.
    // Step 4. Verify that warning message is displayed:
    // “first name must be more than 2 and less than 64 characters long”
    @Test
    public void test3(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(registrationFormBy).click();
        BrowserUtils.wait(3);

        driver.findElement(By.name("firstname")).sendKeys("a");
        BrowserUtils.wait(3);

        WebElement invalidMessage = driver.findElement(By.xpath("//*[@data-bv-for=\"firstname\" and @data-bv-result=\"INVALID\"]"));
        BrowserUtils.wait(3);
        assertTrue(invalidMessage.isDisplayed());

    }

    //Step 3. Enter only one alphabetic character into last name input box.Step
    // 4. Verify that warning message is displayed:
    // “The last name must be more than 2 and less than 64 characters long”

    @Test
    public void test4(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(registrationFormBy).click();
        BrowserUtils.wait(3);

        driver.findElement(By.name("lastname")).sendKeys("a");
        BrowserUtils.wait(3);

        WebElement invalidMessage = driver.findElement(By.xpath("//*[@data-bv-for=\"lastname\" and @data-bv-result=\"INVALID\"]"));
        BrowserUtils.wait(3);
        assertTrue(invalidMessage.isDisplayed());
    }

    // verify valid data
    @Test
    public void test5(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        HashMap<String, String> contact1 = new HashMap<>();
        contact1.put("first name","Mike");
        contact1.put("last name","Tyson");
        contact1.put("username","mike123");
        contact1.put("email","mike1@gmail.com");
        contact1.put("password","MikeTyson123");
        contact1.put("phone","333-445-9876");
        contact1.put("birthday","02/02/2002");


        driver.findElement(registrationFormBy).click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//input[@name=\"firstname\"]")).sendKeys("Mike");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"lastname\"]")).sendKeys("Tyson");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("mike123");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("mike1@gmail.com");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("Mike.123");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("123-345-5454");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@value=\"male\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@name=\"birthday\"]")).sendKeys("02/02/2002");
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//select[@name=\"department\"]//option[5]")).click();
        BrowserUtils.wait(2);
//        Select departmentSelect = new Select(driver.findElement(By.name("department")));
//        departmentSelect.deselectByVisibleText("Department of Engineering");

        driver.findElement(By.xpath("//select[@name=\"job_title\"]//option[5]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//input[@value=\"java\"]")).click();
        BrowserUtils.wait(2);
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        BrowserUtils.wait(4);
        String expected ="You've successfully completed registration!";
        String actual=driver.findElement(By.tagName("p")).getText();
        BrowserUtils.wait(4);
        Assert.assertEquals(actual,expected);

    }

    //temp email
    @Test
    public void test6(){
        driver.get(tempURL);
        BrowserUtils.wait(3);

        String fakeEmail = driver.findElement(By.id("email")).getText();
        driver.navigate().to(URL);
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[text()='Sign Up For Mailing List']")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.name("full_name")).sendKeys("Mike Tyson");
        driver.findElement(By.name("email")).sendKeys(fakeEmail);
        BrowserUtils.wait(3);

        driver.findElement(By.name("wooden_spoon")).click();

        String expected ="Thank you for signing up. Click the button below to return to the home page.";
        String actual = driver.findElement(By.name("signup_message")).getText();
        BrowserUtils.wait(3);
        assertEquals(actual,expected);

        driver.navigate().to(tempURL);

        WebElement sentEmail = driver.findElement(By.xpath("//*[contains(text(),'Thanks for subscribing to practice.cybertekschool.com!')]"));

        assertTrue(sentEmail.isDisplayed());

        sentEmail.click();
        BrowserUtils.wait(3);

        WebElement email = driver.findElement(By.id("odesilatel"));

        assertTrue(email.isDisplayed());
    }


    //Step 2. And click on “File Upload".Step
    // 3. Upload any file with .txt extension from your computer.
    // Step 4. Click “Upload” button.Step
    // 5. Verify that subject is: “File Uploaded!”Step
    // 6. Verify that uploaded file name is displayed.
    @Test
    public void test7(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(fileUploadBy).click();
        BrowserUtils.wait(3);
        WebElement upload = driver.findElement(By.id("file-upload"));
        BrowserUtils.wait(3);

        String filePath="/Users/user/Desktop/text.txt";

        upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();
        BrowserUtils.wait(3);

        String expected = "File Uploaded!";
        String actual = driver.findElement(By.xpath("//*[text()='File Uploaded!']")).getText();

        assertEquals(actual,expected);

    }


    //Step 2. And click on “Autocomplete”.Step
    // 3. Enter “United States of America” into country input box.
    // Step 4. Verify that following message is displayed:
    // “You selected: United States of America”
    @Test
    public void test8 (){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[text()='Autocomplete']")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.xpath("//*[@value=\"Submit\"]")).click();
        BrowserUtils.wait(3);

        String expected = "You selected: United States of America";
        String actual = driver.findElement(By.id("result")).getText();

        assertEquals(actual,expected);

    }


    //Step 1. Go to “https://practice-cybertekschool.herokuapp.com”
    // Step 2. And click on “Status Codes”.
    // Step 3. Then click on “200”.
    // Step 4. Verify that following message is displayed: “This page returned a 200 status code”
    @Test
    public void test9(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[text()='200']")).click();
        BrowserUtils.wait(3);

        String expected = "This page returned a 200 status code.";
        WebElement text = driver.findElement(By.xpath("//p"));
        String actual = text.getText();
        //assertEquals(actual,expected);

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);
    }




    //Step 2. And click on “Status Codes”.
    // Step 3. Then click on “301”.
    // Step 4. Verify that following
    //message is displayed:
    // “This page returned a 301 status code”
    @Test
    public void test10(){
        driver.get(URL);
        driver.manage().window().maximize();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[text()='Status Codes']")).click();
        BrowserUtils.wait(3);

        driver.findElement(By.xpath("//*[text()='301']")).click();
        BrowserUtils.wait(3);

        String expected = "This page returned a 301 status code.";
        System.out.println(driver.findElement(By.xpath("//*[@id='content']/div/p/text()[1]")).getText());
        String actual = driver.findElement(By.xpath("//*[@id='content']/div/p/text()[1]")).getText();
        assertEquals(actual,expected);

        System.out.println("expected = " + expected);
        System.out.println("actual = " + actual);


    }



















    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
