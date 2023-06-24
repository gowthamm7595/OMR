package com.amazon;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewTask {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		WebElement searchbar = driver.findElement(By.id("APjFqb"));
		searchbar.sendKeys("Selenium");
		
		WebElement element1 = driver.findElement(By.xpath("//div[@id='ERWdKc']"));
		
		String actMsg = element1.getText();
		
		Assert.assertEquals("verify the seleneium jar download in present", actMsg);
	}
}
