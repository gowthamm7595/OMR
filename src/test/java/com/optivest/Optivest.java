package com.optivest;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Optivest {

	@Test
	public void Test1() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.optivest.co.za/careers/#");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement saving = driver.findElement(By.xpath("(//span[contains(text(),'Saving you money')])[1]"));
		saving.click();

		WebElement pocket = driver.findElement(By.xpath("(//span[text()='Prevent out of pocket payments'])[1]"));
		pocket.click();

		WebElement payment = driver.findElement(By.xpath("//h1[text()='Prevent out of pocket payments']"));
		String text = payment.getText();
		System.out.println(text);
		Assert.assertEquals("verify the message", text, "Prevent out of pocket payments");

		WebElement firstname = driver.findElement(By.xpath("//input[@id='quote_gapcover_name']"));
		firstname.sendKeys("Gowthamm");

		WebElement lastname = driver.findElement(By.id("quote_gapcover_surname"));
		lastname.sendKeys("praba");

		WebElement phone = driver.findElement(By.id("quote_gapcover_phone"));
		phone.sendKeys("9080208892");

		WebElement email = driver.findElement(By.id("quote_gapcover_email"));
		email.sendKeys("gowthamm98765@gmail.com");

		WebElement scheme = driver.findElement(By.xpath("(//select[@name='gapcover_medicalaid_name'])[1]"));
		Select select = new Select(scheme);
		select.selectByIndex(5);

		WebElement adults = driver.findElement(By.id("FamAdults"));
		Select select2 = new Select(adults);
		select2.selectByIndex(2);

		WebElement child = driver.findElement(By.id("FamChildren"));
		Select select3 = new Select(child);
		select3.selectByIndex(1);

		WebElement principal = driver.findElement(By.name("gapcover_FamilyComp[1][Age]"));
		principal.sendKeys("1");

		WebElement adultdep = driver.findElement(By.name("gapcover_FamilyComp[2][Age]"));
		adultdep.sendKeys("1");

		WebElement checkbox = driver.findElement(By.xpath("(//div//label//input)[1]"));
		checkbox.click();

		WebElement submit = driver.findElement(By.xpath("(//button[text()='Submit'])[1]"));
		submit.click();

		WebElement successmsg = driver
				.findElement(By.xpath("//span[contains(text(),'Thank you, we have received your submission')]"));
		String actmsg = successmsg.getText();
		System.out.println(actmsg);
		Assert.assertEquals("verify the success msg", actmsg,
				"Thank you, we have received your submission. We will be in contact soon!");

		Thread.sleep(3000);

		WebElement req = driver.findElement(By.xpath("//strong[text()='Request']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", req);
		js.executeScript("arguments[0].click()", req);

	}

}
