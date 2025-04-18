package com.in;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class WaitingMechanismTestCase {

	public WaitingMechanismTestCase() {
		
	}

	public static void main(String[] args) throws InterruptedException {
	
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(NoSuchElementException.class);
			
			driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
			driver.findElement(By.xpath("//input[@id='adder']")).click();
			//Thread.sleep(3000);
			//driver.findElement(By.xpath("//div[@id='box0']")).isDisplayed();
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='box0']"))).isDisplayed();
			
//			wait.until(new Function<WebDriver, WebElement>() {
//
//				@Override
//				public WebElement apply(WebDriver t) {
//					
//					return t.findElement(By.xpath("//div[@id='box0']"));
//				}
//				
//			}
//			
//			).isDisplayed();
			
			wait.until( dr -> dr.findElement(By.xpath("//div[@id='box0']")) ).isDisplayed();
			
			driver.quit();
	}

}
