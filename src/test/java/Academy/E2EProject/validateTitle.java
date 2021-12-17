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

public class validateTitle extends Base{
	
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public void setup() throws IOException
	{
		driver = initializeDriver();
		log.info("validateTitle - Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("validateTitle - Driver got url from properties file");
		driver.manage().window().maximize();
	}

	@Test
	public void validateAppTitle()
	{
		LandingPageObject lpo = new LandingPageObject(driver);

		String actualTitle = lpo.getTitle().getText();
		Assert.assertEquals(actualTitle, "FEATURED COURSES");
		log.info("validateTitle - Successfully validated the title");
	}

	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
}