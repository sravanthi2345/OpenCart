package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePageObject {
	
	//constructor:
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators:
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement myAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;
	
	//actionmethods:
public boolean isMyAccountPageExist()
{
	try 
	{
	 return(myAccount.isDisplayed()); //we are not doing any validations only returning here validations can be done in testcase
	}
	catch(Exception e)
		{
			return false;
			
		}
}
 public void logoutLink()
 {
	 lnkLogout.click();
 }

}
