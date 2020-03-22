package com.automation.officeHours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumOH2 {
    public static void main(String[] args) throws Exception {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com");

        Thread.sleep(3000);
        WebElement  search_box = driver.findElement(By.id("search_query_top"));

        search_box.sendKeys("tshirt"+ Keys.ENTER);
        Thread.sleep(3000);

        /*
        <p class="alert alert-warning">
					No results were found for your search&nbsp;"tshirt"
		</p>

        * */

        WebElement error = driver.findElement(By.xpath("//p[@class='alert alert-warning']"));

        String errorText = error.getText();
        // .getText() --> returns String from the element

        System.out.println("Error text"+errorText);
         search_box = driver.findElement(By.id("search_query_top"));
         search_box.clear();

        search_box.sendKeys("t-shirt"+Keys.ENTER);

        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.getStackTrace();
        }

        WebElement count = driver.findElement(By.className("product-name"));

        System.out.println("items found "+ count.getText());

        /*
        a class="button ajax_add_to_cart_button btn btn-default" href="http://automationpractice.com/index.php?controller=cart&amp;add=1&amp;id_product=1&amp;token=e817bb0705dd58da8db074c69f729fd8" rel="nofollow" title="Add to cart" data-id-product="1">
										<span>Add to cart</span>
									</a>
        a - link
        span - description

         */

        WebElement add_cart = driver.findElement(By.className("button ajax_add_to_cart_button btn btn-default"));

        add_cart.click();



//        Thread.sleep(5000);
//
//
//        driver.quit();


    }
}
