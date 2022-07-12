package org.maven.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Argument;

public class BaseClass {

	public static  WebDriver driver;
	
	public static void getDriver() {
	
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
}
	public static void loadUrl(String url ){
		driver.get(url);
		
	}
	public WebElement findElementById(String attributeValue) {
		WebElement element =driver.findElement(By.id(attributeValue));
				return element;
	}
	public WebElement findElementByName(String attributeValue) {
		WebElement element =driver.findElement(By.name(attributeValue));
		return element;
	}
	public WebElement findElementByClass(String attributeValue) {
		WebElement element =driver.findElement(By.className(attributeValue));
		return element;
	}
	public WebElement findElementByXpath(String attributeValue) {
		WebElement element =driver.findElement(By.xpath(attributeValue));
		return element;
	}
	public void type(WebElement element,String data) {
		element.sendKeys(data);
	}
	public void click(WebElement element) {
		element.click();
	}
	public static void maximize() {
		driver.manage().window().maximize();
	}
	public void selectByIndex(WebElement element,int index) {
		Select select =new Select(element);
		select.selectByIndex(index);
	}
	public void selectByText(WebElement element,String text) {
		Select select =new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByValue(WebElement element,String value) {
		Select select =new Select(element);
		select.selectByValue(value);
	}
	public void clearText(WebElement element) {
		element.clear();
	}
	public String getData(String sheetName, int rowNo, int cellNo) throws Exception {
		String res =null;
		File file =new File("C:\\Users\\Suresh Kumar G\\eclipse-workspace\\SampleExcel\\excel_Sample\\maven.xlsx");
		FileInputStream input =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(input);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			res= cell.getStringCellValue();
			
			break;
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				java.util.Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				res=dateFormat.format(dateCellValue);
			}else {
				double numericCellValue = cell.getNumericCellValue();
				BigDecimal valueOf = BigDecimal.valueOf(numericCellValue);
				res=valueOf.toString();
			}
		default:
			break;
		}
		return res;
		
	}
	public void updateData(String sheetName,int rowNo,int cellNo,String oldData,String newData) throws Exception {
		File file =new File("C:\\Users\\Suresh Kumar G\\eclipse-workspace\\SampleExcel\\excel_Sample\\maven.xlsx");
		FileInputStream input =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(input);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row =sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String value = cell.getStringCellValue();
		if(value.equals(oldData)) {
		cell.setCellValue(newData);
		}
		FileOutputStream output=new FileOutputStream(file);
		workbook.write(output);
	}
	public void writeData(String sheetName,int rowNo,int cellNo,String Data) throws Exception {
		
		File file =new File("C:\\Users\\Suresh Kumar G\\eclipse-workspace\\SampleExcel\\excel_Sample\\maven.xlsx");
		FileInputStream input =new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook(input);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row =sheet.getRow(rowNo);
		Cell cell = row.createCell(cellNo);
			cell.setCellValue(Data);
		FileOutputStream output=new FileOutputStream(file);
		workbook.write(output);
	}
	public String getAttribute(WebElement element) {
		String text2 = element.getAttribute("value");
		return text2;
	}
	public static void closeAllWindows() {
		driver.quit();
	}
	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}
	public void actionMoveTo(WebElement element) {
	Actions actions=new Actions(driver);
	actions.moveToElement(element).perform();
	}
	public void actionRightClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element);	
	}
	public void alertAccept() {
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public void alertdismiss() {
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	 public void enterJS(WebElement element,String text) {
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].setAttribute('value','" + text +"')", element);
	 }
	 public void clickJS(WebElement element) {
		 JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].click()", element);
	 }
	public void getJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("return arguments[0].getAttribute('value')", element);
	}
	public void scrollDownJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public  static void scrollUpJS(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		 executor.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	public List<WebElement> selectGetOptions(WebElement element) {
		Select select =new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}
	public String selectGetIndexOption(List<WebElement> options,int index) {
		WebElement getIndex = options.get(index);
		String text = getIndex.getText();
		return text;
	}
	public String selectGetAttribute(List<WebElement> options,int index) {
		WebElement getIndex = options.get(index);
		String text = getIndex.getAttribute("value");
		return text;
	}
	public String selectGet(List<WebElement> options,int index) {
		WebElement getIndex = options.get(index);
		String text = getIndex.getAttribute("value");
		return text;
	}
	public static void createWorkbook(String path,String sheetName,int rowNo, int cellNo, String value) throws Exception {
		File file =new File(path);
		//FileInputStream input=new FileInputStream(file);
		Workbook workbook =new XSSFWorkbook();
		Sheet sheet=workbook.createSheet(sheetName);
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
			Row row =sheet.createRow(rowNo);
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.createCell(cellNo);
				
				cell.setCellValue(value);
			}
		}
		FileOutputStream output=new FileOutputStream(file);
		workbook.write(output);	
		
}
	
	
	
	
	
	
	
	
	
	
	
}