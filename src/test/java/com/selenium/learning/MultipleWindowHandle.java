package com.selenium.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleWindowHandle {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		
		String parentId = driver.getWindowHandle();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Privacy Policy")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windowsId = new ArrayList<String>(windowHandles);
//		for(String id:windowsId) {
//			if(!id.equals(parentId)) {
//				driver.switchTo().window(id);
//			}
//			
//		}
		for(int i=0;i<=windowsId.size();i++) {
			driver.switchTo().window(windowsId.get(1));
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[normalize-space()='View printable version']")).click();
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
