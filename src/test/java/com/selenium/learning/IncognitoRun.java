 package com.selenium.learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IncognitoRun {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch= new ChromeOptions();
		ch.addArguments("--incognito");
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY, ch);
		WebDriver driver = new ChromeDriver(ch);
		driver.get("https://www.facebook.com/login");
		
		
	}
 
}
