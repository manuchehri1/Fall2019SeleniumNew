package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    // runs only
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("Before Suite");
    }



    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass (){
        System.out.println("After Class");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("After Method");
    }


    @Test
    public static void test1(){
        System.out.println(" test1");
        String expected = "apple";
        String actual ="apple";
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void test2(){
        System.out.println("test2");
        int num1 = 5;
        int num2 = 10;

        // it calls hard assertion.
        // if assertion fails - it stops the execution
        Assert.assertTrue(num1<num2);
    }

}
