package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Joylocks
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
      //  driver.get("https://staging.joylocks.com/");
        driver.get("https://joylocks.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,2200)", ""); // Scrolling the page
        Thread.sleep(3000);
        driver.findElement(By.xpath(("//*[@class='custom-btn mainProduct_selection']"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(("//*[@class='txtSec']"))).click();
        driver.findElement(By.xpath(("//*[@class='imgSec']"))).click();
        driver.findElement(By.id("A Little Only I notice it")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='no']/figure/figcaption")).click();
        // explicit wait - to wait for the compose button to be click-able
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Both']/figure/figcaption")));
        // click on the compose button as soon as the "compose" button is visible
        driver.findElement(By.xpath("//div[@id='Both']/figure/figcaption")).click();

        // WebElement dob = driver.findElement(By.id("$birthField"));
        //WebElement birthField = driver.findElement(By.xpath("//*[@id='dob']"));
        // driver.findElement(By.xpath("//*[@id='dob']")).click();
        // WebElement birthField = driver.findElement(By.xpath("//*[@id=\"dob\"]"));
        WebElement birthField  = driver.findElement(By.xpath("//input[@id='dob']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String dob = "01/11/1995";
        executor.executeScript("arguments[0].value='"+ dob +"';", birthField);
        executor.executeScript("arguments[0].click();", birthField);
        // driver.FindElement(By.Id("Value")).SendKeys(Keys.Enter);
        //birthField.sendKeys(Keys.ENTER);
        //WebElement element = driver.findElement(By.id(“elementId”));
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.moveToElement(birthField).click().sendKeys(Keys.ENTER).build().perform();

        // explicit wait - to wait for the compose button to be click-able
      // WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
       // wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='continueDob']")));
        // click on the compose button as soon as the "compose" button is visible
       // driver.findElement(By.xpath("//button[@id='continueDob']")).click();
        driver.findElement(By.xpath("//button[@id='continueDob']")).click();
        WebElement radio1 = driver.findElement(By.id("male"));
        radio1.click();
        WebElement dropdown =  driver.findElement(By.xpath("//input[@id='first_name']"));
        dropdown.click();
        dropdown.sendKeys("Test");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,550)", "");
        WebElement dropdown2 =  driver.findElement(By.xpath("//input[@id='last_name']"));
        dropdown2.click();
        dropdown2.sendKeys("Test");
        WebElement dropdown3 =  driver.findElement(By.xpath("//input[@id='customer_email']"));
        dropdown3.click();
        dropdown3.sendKeys("test@codeclouds.com");
        Thread.sleep(3000);
        JavascriptExecutor jsec = (JavascriptExecutor) driver;
        jsec.executeScript("window.scrollBy(0,150)", "");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.tagName("figcaption")).click();
        driver.findElement(By.xpath("//div[@id='noPregnant']//figcaption[contains(text(),'No')]")).click();
        driver.findElement(By.xpath("//div[@id='step-5']//figcaption[contains(text(),'No')]")).click();
        driver.findElement(By.xpath("//div[@id='noAllergies']//figcaption[contains(text(),'No')]")).click();
        driver.findElement(By.xpath("//div[@id='noMedications']//figcaption[contains(text(),'No')]")).click();
        driver.findElement(By.xpath("//button[@id='modalNo']")).click();








        driver.close();

    }


}
