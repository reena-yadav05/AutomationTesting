//TestCase_04 – Validate the ‘Update location’ feature.
//# 1. Launch Chrome browser.
//# 2. Launch URL https://www.amazon.in
//# 3. Click on the location select option. (right top corner)
//# 3. Enter valid pincode (i.e. 400XXX)
//# 4. Click on the apply button.
//# 5. Validate that the mentioned pincode appears on the location select option.
//# 6. Close the browser.


package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObjects.HomePage;

public class AmazonTest4 extends BaseTest {
	
	public HomePage home;
	String pin = "400068";
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
	}
	 
	@Test
	public void testUpdatePincode() throws InterruptedException {
		home.updatePincode(pin);
		Assert.assertTrue(home.verifyIfPincodeIsUpdated(pin), "Pincode not updated");
	}
	
	
	

}
