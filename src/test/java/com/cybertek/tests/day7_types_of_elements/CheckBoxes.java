package com.cybertek.tests.day7_types_of_elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxes {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        WebElement checkBox1 = driver.findElement(By.xpath("//input[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("//input[2]"));

        System.out.println(checkBox1.isSelected());
        System.out.println(checkBox2.isSelected());

        Assert.assertFalse(checkBox1.isSelected(), "verify checkbox1 is selected");
        Assert.assertTrue(checkBox2.isSelected(), "verify checkbox2 is selected");

        checkBox1.click();

        Assert.assertTrue(checkBox1.isSelected(), "verify checkbox1 is selected ");
        Assert.assertTrue(checkBox2.isSelected(), "verify checkbox2 is selected");


    }



}
