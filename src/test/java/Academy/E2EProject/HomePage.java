package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPageObject;
import pageObjects.LoginPageObject;
import resources.Base;

public class HomePage extends Base{
	
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver = initializeDriver();
		
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String pass) throws IOException
	{
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		LandingPageObject lpo = new LandingPageObject(driver);
		lpo.clickLogin().click();
		
		LoginPageObject lo = new LoginPageObject(driver);
		lo.getEmail().sendKeys(username);
		log.info("HomePage - Username is entered");
		lo.getPassword().sendKeys(pass);
		log.info("HomePage - Password is entered");
		lo.clickLogin().click();
		log.info("HomePage - Login button is clicked");
		
		log.info("HomePage - User is successfully logged in");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		// Columns stands for how many values for each test
		Object[][] data = new Object[2][2];
		
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "12345";
		
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "456456456";
		
		return data;
	}
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
