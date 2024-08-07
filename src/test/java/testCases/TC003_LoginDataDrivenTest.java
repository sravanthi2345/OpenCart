package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;
/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC003_LoginDataDrivenTest extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
   
	public void dataDrivenTest(String email,String password,String exp)
	{
		logger.info("****Started TC003_LoginDataDrivenTest****");
		try
		{
	     HomePage hp=new HomePage(driver);
	     hp.lnkAccount();
	     logger.info("Clicked On My Account Link In HomePage");
	     hp.loginLink();
	     logger.info("Clicked On Login Link");
	     LoginPage lp=new LoginPage(driver);
	     lp.setEmail(email);
	     lp.setPassword(password);
	     lp.loginButton();
	     MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExist();
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(targetpage==true)
			{
				macc.logoutLink();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(targetpage==true)
			{
				macc.logoutLink();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
	catch(Exception e)
	{
		Assert.fail("An exception occurred: " + e.getMessage());
	}
		
	logger.info("**** Finished TC003_LoginDataDrivenTest *****");
	     
	}
}
