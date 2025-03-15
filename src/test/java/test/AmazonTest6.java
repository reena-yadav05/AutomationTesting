//Test_Case_06
//# Steps
//# 1. Launch Chrome browser.
//# 3. Launch URL https://www.amazon.in
//# 4. Search for "Samsung Galaxy"
//# 5. Click on the first search Result. (It will open in a new window)
//# 6. Add the product to the cart.
//# 7. Come back to the main window and click on the cart option
//# 8. Validate if the product is there in the cart using product text. (Put validation)
//# 9. Make the test Case Pass else Fail
//# 10. Close the browser


package test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import base.BaseTest;
import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ProductPage;

public class AmazonTest6 extends BaseTest { 
	
	public HomePage home;
	public ProductPage product;
	public CartPage cart;
	
	@BeforeClass
	public void preTest() {
		home = new HomePage(driver);
		product = new ProductPage(driver);
		cart = new CartPage(driver);
	}	
	
	@Test
	public void testAddToCart() {
		home.search("Samsung Galaxy");
		String productName = home.getFirstProductNameFromList();
		home.viewFirstProductFromList();
		switchToChildWindow();
		product.addToCart();
		switchToParentWindow();
		home.goToCart();
		cart.verifyIfCartIsNotEmpty();
		Assert.assertEquals(cart.getProductNameFromCart(), productName);
	}

}
