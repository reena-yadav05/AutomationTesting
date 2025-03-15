package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	public WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	PageObjects / Elements /Locators
	@FindBy(xpath = "//*[contains(text(),'Your Amazon Cart is empty')]")
	private WebElement title_emptyCart;

	@FindBy(xpath = "//*[@class=\"a-link-normal sc-product-link sc-product-title aok-block\"]")
	private WebElement txt_cartProductName;

	@FindBy(id = "sc-active-items-header")
	private WebElement title_ShoppingCart;

//	Action Methods
	public WebElement returnEmptyPageTitle() {
		return title_emptyCart;
	}

	public String getProductNameFromCart() {
		return txt_cartProductName.getText();
	}

	public WebElement getCartTitle() {
		return title_ShoppingCart;
	}

	public void verifyIfCartIsNotEmpty() {
		try {
			while (title_emptyCart.isDisplayed()) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
		}
	}

}
