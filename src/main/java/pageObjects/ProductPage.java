package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	boolean flag = false;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	Loactors
	@FindBy(xpath = "//*[@id='add-to-cart-button'][@type='submit']")
	private WebElement btn_AddToCart;
	
	
	
	
//	Action Methods
	public void addToCart() {
		btn_AddToCart.click();
	}
	
	

}
