//package test;
//
//import java.sql.Driver;
//
//import org.openqa.selenium.interactions.Actions;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import pageObjects.HomePage;
//
////Test_Case_09
////# Steps
////# 1. Launch Chrome browser.
////# 2. Launch URL https://www.amazon.in
////# 3. Scroll down to the bottom of the home page.
////# 4. Click on the language select element and select the हिन्दी language
////# 5. Add an assertion to make sure the language of the page has been changed to the selected language.
////# 6. Now again go to the bottom of the home page
////# 7. Click on the language select element and select the English language
////# 8. Add assertion to make sure the language is changed back to English.
////# 9. Close the browser.
//public class AmazonTestCase09 {
//	
//	public Actions action; 
//	public HomePage home ; 
//	public boolean flag = false; 
//	
//	@BeforeClass
//	public void preTest() {
//		home = new HomePage(driver);
//		
//		
//	} 
//	@Test
//	
//	public void AmazonTestCase09() throws InterruptedException{
//		
//	//# 3. Scroll down to the bottom of the home page.
//		action = new Actions(driver);
//		action.scrollToElement(home.getLanguage());
//		
//		
//		//# 4. Click on the language select element and select the हिन्दी language
//		home.openLanguageSeclection();
//		Thread.sleep(2000);
//		home.selectLanguage("Hindi");
//		Thread.sleep(2000);
//		
//		//# 5. Add an assertion to make sure the language of the page has been changed to the selected language.
//		Assert.assertEquals(driver.getCurrentUrl , "https" null);
//		if (driver.getCurrentUrl().contains("en_IN")) {
//			flag = true;
//			else {
//				flag = false;
//				Assert.assertTrue(flag);
//				
//			}
//			
//		}
//		
//		//# 6. Now again go to the bottom of the home page
//		action.scrollToElement(home.getLanguagElement());
//		
//		
//		//# 7. Click on the language select element and select the English language
//		home.openLanguageSeclection();
//		Thread.sleep(3000);
//		home.selectLanguage("English");
//		Thread.sleep(2000);
//		
//		
////# 8. Add assertion to make sure the language is changed back to English.
//		
//		Assert.assertEquals(driver.getCurrentUrl , "https" null);
//		if (driver.getCurrentUrl().contains("en_IN")) {
//			flag = true;
//			else {
//				flag = false;
//				Assert.assertTrue(flag);
//		//# 9. Close the browser.
//		
//		driver.quit();
//		
//		
//	}
//	
//	
//
//}
