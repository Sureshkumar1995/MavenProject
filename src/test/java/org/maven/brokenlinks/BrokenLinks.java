package org.maven.brokenlinks;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	public static void main(String[] args) throws Exception {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int count=0;
		for (int i = 0; i < allLinks.size(); i++) {
			WebElement element = allLinks.get(i);
			String attribute = element.getAttribute("href");
			URL url = new URL(attribute);
			URLConnection openConnection = url.openConnection();
			HttpsURLConnection connection=(HttpsURLConnection)openConnection;
			int responseCode = connection.getResponseCode();
			
			if(responseCode != 200) {
				
				count++;
	
				System.out.println("broken links :"+attribute);
			}
		}
		System.out.println(count);
		
		driver.quit();
		
	}

}
