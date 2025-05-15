package com.in;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	
	public static void EntryINTOFrameUSingWait(WebDriver driver, WebElement frame) {
		
		WebDriverWait expWait= new WebDriverWait(driver, Duration.ofSeconds(10));
		expWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));	
	}
	
	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
	//	EntryINTOFrameUSingWait(driver,driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement srcElement=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dstElement=driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).build().perform();
		System.err.println(dstElement.getText());
		
		
		
	}

}
