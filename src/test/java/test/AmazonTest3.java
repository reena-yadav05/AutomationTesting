//TestCase_03 – Validate the Cart page.
//# Steps
//# 1. Launch Chrome browser.
//# 3. Launch URL https://www.amazon.in
//# 4. Click on the Cart option, (right top corner)
//# 5. Wait for the page to load. (Use explicit or implicit wait)
//# 6. Capture page title.
//# 7. if 'Shopping Cart' is there in the page title, test passed, else fail.
//# 8. Close the browser.


package test;

import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.HomePage;

public class AmazonTest3 extends BaseTest{
	
	HomePage home;
	CartPage cart;
	boolean flag = false;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver );
		cart = new CartPage(driver);
	}
	
	@Test
	public void test3() {
		
//		4. Click on the Cart option, (right top corner)
		home.goToCart();
		
//		5. Wait for the page to load. (Use explicit or implicit wait)
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cart.returnEmptyPageTitle()));
		
//		6. Capture page title.
		String pageTitle = driver.getTitle();
		
//		7. if 'Shopping Cart' is there in the page title, test passed, else fail.
		if(pageTitle.contains("Shopping Cart")) {
			flag = true;
			System.out.println("Pass");
		} else {
			flag = false;
			System.out.println("Fail");
		}
		
		Assert.assertTrue(flag, "The test has failed");
		
	}

}
