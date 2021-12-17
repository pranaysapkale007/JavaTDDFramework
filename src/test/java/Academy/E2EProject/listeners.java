package Academy.E2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class listeners extends Base implements ITestListener{

	ExtentReports extent = ExtentReporterNG.getReportObject();
	ExtentTest test;
	
	// to avoid parallel execution issue with overriding
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	
	public void onTestStart(ITestResult result) {
		// Add test case to Extent report
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		//attaching log in extent report
		extentTest.get().fail(result.getThrowable());
		
		
		WebDriver driver = null;
		// Get test method name
		String tcname = result.getMethod().getMethodName();
		
		try {
			
			//get name of failed method
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			
		} catch(Exception e){
			
		}
		
		//Code to capture screenshot
		try {
			// attach screenshot to extent report
			extentTest.get().addScreenCaptureFromPath(getScreenshotPath(tcname,driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
	}

	
}
