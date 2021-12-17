package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPageObject {
	
	public WebDriver driver;
	
	public LandingPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	//Objects
	By login = By.xpath("//a[@href='https://rahulshettyacademy.com/sign_in/']");
	By landingTitle = By.xpath("//h2[text()='Featured Courses']");
	By navBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	//Methods
	public WebElement clickLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(landingTitle);
	}
	
	public WebElement getNavigationBar()
	{
		return driver.findElement(navBar);
	}
}
