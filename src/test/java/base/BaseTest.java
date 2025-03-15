package base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentTest;

import java.util.logging.Logger;

public class BaseTest {

	public static  WebDriver driver;
    public static final Logger logger = Logger.getLogger(BaseTest.class.getName());

	public String parentWindow;
    public WebDriverWait wait; // Declare WebDriverWait here
    public Properties prop;
    public static ExtentTest test;
	@BeforeTest
	public void setUp() throws InterruptedException, IOException {
        prop = new Properties();
        FileInputStream file = new FileInputStream(
                System.getProperty("user.dir") + "/src/main/java/utilities/config.properties");
        prop.load(file);

        // Browser selection
        if (prop.getProperty("browser").equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser specified in config.properties");
        }

			
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("baseurl"));
		Thread.sleep(10000);
		driver.manage().deleteAllCookies();
		
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize wait 
	}

	@AfterTest 
	public void tearDown() { 
		driver.quit();
	}

	public void switchToChildWindow() {
		parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> itr = windowHandles.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			driver.switchTo().window(childWindow);
		}
	}
	 
	public void switchToParentWindow() {
		driver.switchTo().window(parentWindow);
	}

	

	public void fetchDatafromExcel() throws IOException {
		
		File excelFile = new File(System.getProperty("user.dir") + "testdataxlsx");
		FileInputStream file = new FileInputStream(excelFile);
		
		
		
		// to load the workbook 
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		// to speficy sheet 
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		// to find the cell 
		DataFormatter format = new DataFormatter();
		
		String username , mobile , password;
		
		for(int i = 1 ; i<=10 ; i++) {
			username = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username "+username);
			
			XSSFCell cell = sheet.getRow(i).getCell(2);
			mobile = format.formatCellValue(cell);
			System.out.println("Mobile :" +mobile);
			
			password = sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password : " +password);
			
		}
		
		workbook.close();
		
	}
	
	
	public static String getDateTime() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
		
	}

	
	public String getScreenshotPath(String testCaseName , WebDriver driver) throws IOException{
		TakesScreenshot tScreenshot = (TakesScreenshot) driver ;
		File Source = tScreenshot.getScreenshotAs(OutputType.FILE);
		String destPath = System.getProperty("user.dir") + "/Screenshots/" +testCaseName +".png" ;
		FileUtils.copyFile(Source, new File(destPath));
		
		return destPath;
	}
	
}








