package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest2 {
	
	
	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Search 2");
		
		driver.findElement(By.name("btnK")).click();
		
	}
	
	
	

}
