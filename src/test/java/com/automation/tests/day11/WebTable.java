package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTable {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        // headless runs test case without opening browser like make broser invisble
//        WebDriverManager.chromedriver().version("79").setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true);


        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }


    @Test
    public void getColumnNames(){

        List<String> expected = Arrays.asList("Last Name","First Name", "Email","Due","Web Site","Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }

        ////BrowserUtils.getTextFromWebElements(columnNames) ==>
        //// this method takes the text of every single webElement and puts it into collection of strings
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);


    }


    @Test
    public void verifyRowCount(){

        List<WebElement> rows =driver.findElements(By.xpath("//table[1]//tbody//tr"));

        Assert.assertEquals(rows.size(),4);

    }


    @Test
    public void getSpecificColumn() {

        // td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
//fbach@yahoo.com	//table[1]//td[text()='fbach@yahoo.com’]//following-sibling::td/a[text()=‘delete’]
    }

//    @Test
//    public void verifyDeletedEmail(){
//        BrowserUtils.wait(4);
//        List<WebElement> rows =driver.findElements(By.xpath("//table[1]//tbody//tr"));
//        WebElement deleteBtn =driver.findElement(By.xpath("//table[1]//td[text()='fbach@yahoo.com']//following-sibling::td/a[text()='delete']"));
//
//        for (WebElement eachRow : rows) {
//            if (eachRow.getText().contains("jsmith@gmail.com"));{
//
//                deleteBtn.click();
//            }
//        }
//        BrowserUtils.wait(4);
//        List<WebElement> rows2 =driver.findElements(By.xpath("//table[1]//tbody//tr"));
//
//        Assert.assertEquals(rows2.size(),3,"The email is not deleted");
//    }
    /**
     * Go to tables example page
     * Delete record with jsmith@gmail.com email
     * verify that number of rows is equals to 3
     * verify that jsmith@gmail.com doesn't exists any more in the table
     */
    @Test
    public void deleteRowTest() {
        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();
        BrowserUtils.wait(3);
        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
        Assert.assertEquals(rowCount, 3);
        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
    }

    /**
     * Let's write a function that will return column index based on column name
     */
    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            String actualColumnName = columnNames.get(i).getText();

            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));

            if (actualColumnName.equals(columnName)) {
                index = i + 1;
                break;
            }
        }

        Assert.assertEquals(index, 3);

    }

    @Test

    public void getSpecificCell(){
        int row =3;
        int column =5;
        String xpath = "//table[1]//tbody//tr["+row+"]//td["+column+"]";

        String expected = "http://www.jdoe.com";
        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(),expected);


    }






}
