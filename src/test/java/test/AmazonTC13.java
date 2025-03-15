package test;
//Test_Case_13
//# Steps:
//# 1. Launch Chrome browser.
//# 2. Launch URL https://www.amazon.in
//# 3. Locate all the header menu options and get the count.
//# 4. Click on each header menu and check the page URL.
//# 5. Assert if the page URL is the same as the 'href' attribute of the header menu.
//# 6. Close the browser.
//

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;

public class AmazonTC13 extends BaseTest {

	HomePage home; 
	
	@BeforeClass
	public void pretest() {
		
		home = new HomePage(driver);		
		
	}
	
	@Test
	
	public void amazonTC13() {
		
		home.validateHeaderList();
       
	}
}
