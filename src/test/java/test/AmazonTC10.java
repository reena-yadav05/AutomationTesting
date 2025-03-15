package test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;

//Test_Case_10
//# Steps
//# 1. Launch Chrome browser.
//# 2. Launch URL https://www.amazon.in
//# 3. Search for “Mobile Phones”.
//# 4. Scroll all the mobiles till you find the “Limited time deal” mobile phone.
//# 5. Print the phone name.
//# 6. Close the browser.

public class AmazonTC10  extends BaseTest {

	HomePage home; 
	 
	
	
	@BeforeClass
	
	public void pretest() {
		
		home = new HomePage(driver);  // Pass WebDriverWait to HomePage
		
					
	}
	
	@Test
	
	public void searchphone() {
		home.search("Mobile Phone");
		
	    home.printLimitedDealPhones();  // Step 4 & 5: Print mobile names with deals
	    System.out.println("The first product from the phone list is: " + home.getFirstProductNameFromList());
		System.out.println("The first Phone name is : " + home.getFirstProductNameFromList());

		home.getcountoflimiteaddealphone();
		System.out.println("The all limited deal phone names are: " );
		home.printAllLimitedDealPhones();
		
	    
	    
	    
	     



		
	}
	
	
}
