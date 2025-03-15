//TestCase_01 – Launch Amazon.in and validate the page URL
//# Steps
//# 1. Launch Chrome browser.
//# 3. Launch URL https://www.amazon.in
//# 4. Capture the page URL
//# 5. If 'amazon.in' is there in the Page URL, test passed, else, fail.
//# 6. Close the browser.

package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;

public class AmazonTest1 extends BaseTest {

	@Test
	public void AmazonTc1() {
		boolean flag = false;

		if (driver.getCurrentUrl().contains("amazon.in"))
			flag = true;
		else
			flag = false;
 
		Assert.assertTrue(flag);

	}

}
