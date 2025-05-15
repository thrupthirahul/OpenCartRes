package com.in;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://jqueryui.com/datepicker/");
		WebElement frame=driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.cssSelector("#datepicker")).click();

		//Expected date to be selected.
		String month="November";
		String date="24";
		String year="2025";
		
		//WebElement datePicker=driver.findElement(By.cssSelector("#ui-datepicker-div"));
		while(true) {
			//actual month and year
			String AMonth=driver.findElement(By.xpath("//div//span[@class='ui-datepicker-month']")).getText();
			String AYear=driver.findElement(By.xpath("//div//span[@class='ui-datepicker-year']")).getText();
			
			
			if(AMonth.equals(month) && AYear.equals(year)) {
				System.out.println(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText());
				break;
			}
			driver.findElement(By.linkText("Next")).click();
		}
		//select the expected date in the date picker
		List<WebElement> ADates=driver.findElements(By.xpath("//table//tbody//tr//td//a"));
		for(WebElement dt:ADates) {
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		System.out.println("Selected Date::"+driver.findElement(By.cssSelector("#datepicker")).getAttribute("value"));
	}
}
