package com.cybertek.tests.day9_popups_tabs_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class eu2Homework {
    WebDriver driver;
    WebElement element;

    @BeforeMethod
    public void setup(){
        WebDriverFactory.getDriver("chrome");
    }

    @AfterMethod
    public void close(){
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("https://cybertekschool.herokuapp.com");
        element.findElement(By.xpath("//a[@class='btn']")).click();
        element.findElement(By.xpath("//a[@href=\"https://id.heroku.com\"]")).click();
        element.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("merdur@hotmail.com");
        element.findElement(By.id("password")).sendKeys("hosssssssss");
        element.findElement(By.xpath("//button[@name=\"commit\"]")).click();
    }










}
