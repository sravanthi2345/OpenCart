package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePageObject {
	
	//constructor:
	public HomePage(WebDriver driver)
	{
		super(driver);  //invoking immediate parent class constructor using super keyword:
	}
	
	//locators:
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement accountLink;
	@FindBy(xpath="//a[text()='Register']")
	WebElement regLink;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement lnkLogin;
	
	//action methods:
	public void lnkAccount()
	{
		accountLink.click();
	}
	public void lnkRegister()
	{
		regLink.click();
	}
	public void loginLink()
	{
		lnkLogin.click();
	}
}
