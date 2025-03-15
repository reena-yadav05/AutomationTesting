package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import base.BaseTest;
import pageObjects.HomePage;

//Test_Case_11
//# Steps:
//# 1. Launch Chrome browser.
//# 2. Launch URL https://www.amazon.in
//# 3. Go to the end of the page
//# 4. Click on all the footer links one by one and validate the page URL.
//# 5. Add an assertion to pass the test case.
//# 6. Close the browser.
public class AmazonTC11  extends BaseTest{

	HomePage home; 
	
	
	@BeforeClass
	public void pretest() {
		
		home = new HomePage(driver); 
		

}
	
	@Test
	public void amazontc11() throws InterruptedException{
		
		//# 3. Go to the end of the page

		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN);
		
		//# 4. Click on all the footer links one by one and validate the page URL.
		
		
		home.validatefooterlist();
		
		
	}

	
	
}