package org.maven.brokenlinks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpathAmazon {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebElement txtSearch =driver.findElement(By.id("twotabsearchtextbox"));
		txtSearch.sendKeys("iphone");
		WebElement btnSearch = driver.findElement(By.id("nav-search-submit-button"));
		btnSearch.click();
		WebElement getPrice = driver.findElement(By.xpath("//span[.='Apple iPhone 11 (128GB) - Purple']//parent::a//parent::h2//parent::div[1]//following-sibling::div[2]//child::span//child::span"));
		String text = getPrice.getText();
		System.out.println(text);

		
		
		
		
		
		
		
		//span[.='Apple iPhone 11 (128GB) - Purple']//parent::a//parent::h2//parent::div[1]//following-sibling::div[2]//child::span//span[.='
		
	}
	

}
