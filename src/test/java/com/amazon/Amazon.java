package com.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		File file = new File("C:\\Users\\Admin\\Desktop\\eclipse-workspace\\TrainingSession\\Excelsheet\\MyFile.xls");
		FileInputStream stream1 = new FileInputStream(file);
		Workbook workbook = new HSSFWorkbook(stream1);
		Sheet sheet = workbook.getSheet("Sheet1");
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			String value2 = cell.getStringCellValue();
			WebElement element1 = driver.findElement(By.id("twotabsearchtextbox"));
			element1.clear();
			element1.sendKeys(value2, Keys.ENTER);
			
//			Thread.sleep(5000);
//			WebElement element2 = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-none _bXVsd_imgPadding_1Lkpt _bXVsd_container_1DI1V _bXVsd_block_1vI8- _bXVsd_hFull_2lnNw _bXVsd_wFull_3f8b2 _bXVsd_row_3CEm0 _bXVsd_itemsCenter_3flfN _bXVsd_contentCenter_3BjNx'])[1]"));
//			element2.click();
			driver.quit();
		}

	}
}
