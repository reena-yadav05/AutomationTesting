package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;

public class SampleTest extends BaseTest{
	
	@BeforeSuite (description = "Configure/Setup of the test environment/sytem")
	public void beforeSuite() {
		System.out.println("Before Suite");
	}
	
	@BeforeTest(description = "Instantiate WebDriver, Launch Browser, Launch Application")
	public void beforeTest() {
		System.out.println("Before Test"); 
	}
	
	@BeforeClass (description = "Navigate to the test screen, Instantiate the PageFactory classes")
	public void beforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	
	@Test(description = "THis is validating manager login flow")
	public void testLogin() {
		System.out.println("Test Login");
	}
	
	@Test(description = "THis will validate the user flow")
	public void testPrime() {
		System.out.println("Test Prime");
	}
	
	@Test(description = "Cart")
	public void testCart() {
		System.out.println("Test Cart");
	}
	
	@Test(description = "Search")
	public void testSearch() {
		System.out.println("Test Search");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@AfterClass(description = "Logout")
	public void AfterClass() {
		System.out.println("After Class");
	}
	
	@AfterTest(description = "driver.quit();")
	public void afterTest() {
		System.out.println("After Test");
	}
	
	@AfterSuite(description = "Close Configure/Setup of the test environment/sytem")
	public void afterSuite() {
		System.out.println("After Suite");
	}
	

	

}
