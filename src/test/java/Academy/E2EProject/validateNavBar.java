package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPageObject;
import resources.Base;

public class validateNavBar extends Base{
	
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver = initializeDriver();
		log.info("validateNavBar - Driver is initialized");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

	@Test
	public void basePageNavigation() throws IOException
	{
		LandingPageObject lpo = new LandingPageObject(driver);
		Assert.assertTrue(lpo.getNavigationBar().isDisplayed());
		log.info("validateNavBar - validateNavBar is displayed");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}
