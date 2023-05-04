package com.selenium.learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumAutomation {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
		driver.findElement(By.id("username")).sendKeys("123suresh456");
		driver.findElement(By.id("password")).sendKeys("S32J93");
		driver.findElement(By.id("login")).click();

		WebElement dDnLocation = driver.findElement(By.id("location"));

		Select select = new Select(dDnLocation);
		 List<WebElement> options = select.getOptions();
		 int size = options.size();
		System.out.println(size);
		WebElement element = options.get(3);
		String text = element.getText();
		System.out.println(text);
		for(int i=0;i<options.size();i++) {
			WebElement element1= options.get(i);
			String text1 = element1.getAttribute("value");
			System.out.println(text1);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		driver.close();

	}

}
