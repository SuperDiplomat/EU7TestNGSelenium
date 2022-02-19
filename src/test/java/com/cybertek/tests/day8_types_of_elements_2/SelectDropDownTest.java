package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDownTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1. locate your dropdoen just klike any other webwwwlweemwnt witj unique locator
        WebElement dropdownElemnet = driver.findElement(By.id("state"));

        //2. create Select object by padsing thart elemenrt as a constructor with "Select" Class
        Select stateDropdown = new Select(dropdownElemnet);

        List<WebElement> options = stateDropdown.getOptions();
        System.out.println("options.size() = " + options.size());

        //print options one by one
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dropdown");
        //1. locate your dropdoen just klike any other webwwwlweemwnt witj unique locator
        WebElement dropdownElemnet = driver.findElement(By.id("state"));

        //2. create Select object by padsing thart elemenrt as a constructor with "Select" Class
        Select stateDropdown = new Select(dropdownElemnet);

        //Verfy that fist selcetion is Select a STate
        String expectedOption = "Select a State";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify fisrt selection");

        //hOW TO SELECT OPTİONS FROM DROPDOWN
        //1. uSİNG VİSİBLE tEXT
        Thread.sleep(2000);
        stateDropdown.selectByVisibleText("Virginia");

        expectedOption = "Virginia";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"Verify fisrt selection");

        //2.Using index
        stateDropdown.selectByIndex(51);

        expectedOption="Wyoming";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first selection");

        //3.Using Value
        stateDropdown.selectByValue("KS");

        expectedOption= "Kansas";
        actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption,"verify first seletion");


    }

}
