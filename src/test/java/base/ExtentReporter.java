package base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;


public class ExtentReporter extends BaseTest {
	
	static ExtentReports extent;
	static String reportPath;
	
	public static ExtentReports getReporterObject() {
		reportPath = System.getProperty("user.dir")+ "/Reports/TestRpt" +getDateTime() + ".html";
		
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath).viewConfigurer().viewOrder()
				.as(new ViewName [] {ViewName.DASHBOARD , ViewName.TEST}).apply();
		
		reporter.config().enableOfflineMode(true);
		reporter.config().setDocumentTitle("Test Reports");
		reporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
		extent.attachReporter((reporter));
		extent.setSystemInfo("QA", "Reena");
		extent.setSystemInfo("Environment", "QAT");
		extent.setSystemInfo("Approved", "Manager name ");
		return extent;
		
		
	}
	
//	public static String getDateTime() {
//		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());
//		
//	}
//	
//	public String getScreenshotPath(String testCaseName , WebDriver driver) throws IOException{
//		TakesScreenshot tScreenshot = (TakesScreenshot) driver ;
//		File Source = tScreenshot.getScreenshotAs(OutputType.FILE);
//		String destPath = System.getProperty("user.dir") + "/Screenshots/" +testCaseName +".png" ;
//		FileUtils.copyFile(Source, new File(destPath));
//		
//		return destPath;
//	}
//	
//	

}
