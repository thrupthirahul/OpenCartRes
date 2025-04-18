package com.in;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameTestCase {

	public FrameTestCase() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Rahul");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Thrupthi");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);
		
		WebElement frame3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame3));
		//driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Rahul Thrupthi");		
		//inner frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
