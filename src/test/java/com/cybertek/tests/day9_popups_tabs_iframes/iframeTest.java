package com.cybertek.tests.day9_popups_tabs_iframes;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframeTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //hOW TO SWİTCHES TO FRAMES
        //1.Swich using by name or ID attribute of i frame
        driver.switchTo().frame("mce_0_ifr");

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Muhammet erdur");

        //go back to first frame(main html)
        //1.defaultContent(); useful when switching multiple frames
        driver.switchTo().defaultContent();


        //2.Switing with index
        driver.switchTo().frame(0);//first iframe=index 0,1,2...

        //clear before sendkeys
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Muhammet erdur with index");

        //second way to switch parent
        driver.switchTo().parentFrame();

        //Using webElement to swicth to frames
        WebElement iframeElement = driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframeElement);
        driver.findElement(By.cssSelector("#tinymce")).clear();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#tinymce")).sendKeys("Muhammet erdur with WebElement");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        //first switch to frame top
        driver.switchTo().frame("frame-top");

        //then swith to frame middle(child frame)
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());

        driver.switchTo().parentFrame();

        driver.switchTo().frame(2);

        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go to main html to swtich botttum
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);

        System.out.println(driver.findElement(By.tagName("body")).getText());


    }


}
