package com.in;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertTestCase {

	public AlertTestCase() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Alert']")).click();
		Alert alert1=driver.switchTo().alert();
		System.out.println(alert1.getText());
		alert1.accept();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@onclick='myMessage()']")).click();
		Thread.sleep(5000);
		Alert alert2=driver.switchTo().alert();
		System.out.println(alert2.getText());
		alert2.dismiss();
		Thread.sleep(3000);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@onclick='myPromp()']"))).click();
		Alert alert3=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert3.getText());
		alert3.sendKeys("Hello!");
		Thread.sleep(5000);
		
		alert3.accept();
		driver.quit();
		

	}

}
