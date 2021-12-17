package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {
	
public WebDriver driver;
	
	public LoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	//Objects
	
	By emailadd = By.xpath("//input[@id='user_email']");
	By password = By.id("user_password");
	By login_btn = By.name("commit");
	
	//Methods
	public WebElement getEmail()
	{
		return driver.findElement(emailadd);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}

	public WebElement clickLogin()
	{
		return driver.findElement(login_btn);
	}
}
