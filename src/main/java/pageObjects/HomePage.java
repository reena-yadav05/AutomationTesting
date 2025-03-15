package pageObjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class HomePage {
	
	WebDriver driver;
	WebDriverWait wait;
	boolean flag = false;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
		
		public HomePage(WebDriverWait wait) {
			 this.wait = wait; 
			PageFactory.initElements(driver, this);
	       
	}
	
//	Page Objects / Locators / Elements
	@FindBy(id = "nav-cart")
	private WebElement btn_cart;
	
	@FindBy(id = "nav-global-location-popover-link")
	private WebElement btn_location;
	
	@FindBy(id = "GLUXZipUpdateInput")
	private WebElement txt_pincode;
	
	@FindBy(xpath = "//*[@aria-labelledby='GLUXZipUpdate-announce']")
	private WebElement btn_apply;
	
	@FindBy(id = "glow-ingress-line2")
	private WebElement lbl_appliedPincode;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement txt_searchbox;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement btn_search;
	
	@FindBy(xpath = "//*[@class=\"a-link-normal s-line-clamp-2 s-link-style a-text-normal\"]")
	private List<WebElement> lbl_productList;
	
	//@FindBy(xpath= "//*[contains(text(), 'Limited time deal')]")
	@FindBy(xpath= "//*[contains(text(), 'Limited time deal')]/ancestor::div[contains(@class,'s-result-item')]//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal']")
	private List<WebElement> limitedDealmMobile;
	
	@FindBy(xpath="//*[@data-testid='filter-bubble-deals-collection-mobiles']")
	private WebElement mobiledeal;

	
	
	@FindBy(xpath = "//h5[@class='navFooterDescItem_heading']")
		private List<WebElement> lbl_footerList;
	
	
	@FindBy(xpath = "//div[contains(@id, 'nav-main')]//a[contains(@tabindex, '0')]")
	private List<WebElement>lbl_headerList;
	
	
	@FindBy(xpath = "//div[contains(@class, 'a-declarative') and contains(@class, 'GLUX_Inline')]")
	private WebElement fresheaderskiptextElement;
	 
	 
	
	
//	Action Method
	public void goToCart() {
		btn_cart.click();
		driver.navigate().refresh();
	}
	
	public void updatePincode(String pincode) throws InterruptedException {
		btn_location.click();
		Thread.sleep(2000);
		txt_pincode.sendKeys(pincode);
		btn_apply.click();
	}
	
	public boolean verifyIfPincodeIsUpdated(String pincode) throws InterruptedException {
		Thread.sleep(2000);
		if(lbl_appliedPincode.getText().contains(pincode)) {
			flag = true;
		} else {
			flag = false;
		}
		return flag;
	}
	
	public void search(String productname) {
		txt_searchbox.sendKeys(productname);
		btn_search.click();
	}
	
	public void viewFirstProductFromList() {
		lbl_productList.get(0).click();
	} 
	
	public String getFirstProductNameFromList() {
	    if (lbl_productList.size() > 0) { 
	        return lbl_productList.get(0).getText();
	    } 
	    return "No product found!";
	}
	
	
	
//	public void limiteddeal() {
//	    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//	    jsExecutor.executeScript("arguments[0].scrollIntoView(true);", limiteddeal);
//	    wait.until(ExpectedConditions.elementToBeClickable(limiteddeal)).click();
//        System.out.println("Limited Time Deal Phone: " + lbl_productList.get(0).getText());
//
//	    	}
	public void printLimitedDealPhones() {
	    try {
	        // Scroll through all product listings
	        for (WebElement product : lbl_productList) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

	            // Check if "Limited time deal" is present in the product description
	            if (product.getText().toLowerCase().contains("limited time deal")) {
	                System.out.println("Limited Time Deal Phone: " + product.getText());
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("No Limited Time Deal mobiles found.");
	    }
	}
	public void mobiledeal() {
		WebElement mobdeal = wait.until(ExpectedConditions.elementToBeClickable(mobiledeal));
       mobdeal.click();
	}
	
	public void printAllLimitedDealPhones() {
	    System.out.println("Limited Time Deal Phones:");
	    
	    for (WebElement product : limitedDealmMobile) {
	        System.out.println(product.getText());
	    }
	}
	
	public void getcountoflimiteaddealphone(){
		System.out.println("The count of limitead deal phone is : "+ limitedDealmMobile.size());	
	}
	
	
	
	
	public void validatefooterlist() {
		
	        for (WebElement link : lbl_footerList) {
	            String linkText = link.getText();
	            String expectedURL = link.getAttribute("href");

	            System.out.println("Clicking on: " + linkText);
	            link.click();

	            // Validate if the URL contains expected text
	            String actualURL = driver.getCurrentUrl();
	            System.out.println("Navigated to: " + actualURL);

	            // Navigate back to the homepage
	            driver.navigate().back();
	        }
		
	}   
	        
	public void validateHeaderList() {
	    for (WebElement headerLink : lbl_headerList) {
	        String headerLinkText = headerLink.getText();
	        String expectedURL = headerLink.getAttribute("href");

	        System.out.println("Clicking on: " + headerLinkText);

	        // Scroll to the element to ensure visibility
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({inline: 'center'});", headerLink);

	        // Click on header link
	        headerLink.click();

	        // Handle "Skip" pop-up if it appears
	        try {
	            if (fresheaderskiptextElement.isDisplayed()) {
	                System.out.println("Handling 'Skip' pop-up...");
	                fresheaderskiptextElement.click();
	            }
	        } catch (Exception e) {
	           System.out.println("No pop-up appeared, continue execution\n"); // No pop-up appeared, continue execution
	        }

	        // Validate URL
	        String actualURL = driver.getCurrentUrl();
	        System.out.println("Navigated to: " + actualURL);

	        // Assertion to verify expected vs actual URL
//	        Assert.assertEquals(actualURL, expectedURL, "URL mismatch for: " + headerLinkText);

	        // Navigate back to homepage
	        driver.navigate().back();
	    }
	
				
			 
		 }
		 
		 
		 
		 
		 
		 
		 
	 
	

	
//	
//	public WebElement getLanguagElement() {
//		return btn_selectLanguage.click(); 
//	}	
//	public void openLanguageSeclection() {
//		btn_selectLanguage.click();
//	}
//		
//		public void selectLanguage(String Lang) 
//		{
//			if (Lang.equalsIgnoreCase("Hindi"))
//				rad_Hindi.click();
//			else {
//				rad_English.click();
//				
//				btn_SaveLanguage.click();
//			}
//			
//		
	
		
	}
	



