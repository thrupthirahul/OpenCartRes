package com.in;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTestNG {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
    }

    @Test(priority = 1)
    public void handleSimpleAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Alert']"))).click();
        Alert simpleAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Simple Alert Text: " + simpleAlert.getText());
        Assert.assertTrue(simpleAlert.getText().contains("Hello world!"), "Simple alert message mismatch");
        simpleAlert.accept();
    }

    @Test(priority = 2)
    public void handleConfirmAlert() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='myMessage()']"))).click();
        Alert confirmAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Confirm Alert Text: " + confirmAlert.getText());
        Assert.assertTrue(confirmAlert.getText().contains("Hello just appeared"), "Confirm alert message mismatch");
        confirmAlert.accept();
    }

    @Test(priority = 3)
    public void handlePromptAlert() throws InterruptedException {
        String inputText = "Rahul";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@onclick='myPromp()']"))).click();
        Alert promptAlert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Prompt Alert Text: " + promptAlert.getText());
        promptAlert.sendKeys(inputText);
        Thread.sleep(5000);
        promptAlert.accept();

        // Validate the entered input appears on the page
//        String result = driver.findElement(By.id("prompt-demo")).getText();
//        System.out.println("Prompt Result: " + result);
//        Assert.assertTrue(result.contains(inputText), "Prompt result text does not contain input");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}