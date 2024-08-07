package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_Login extends BaseClass{
	
	@Test(groups= {"regression","master"})
	public void loginTest()
	{
		
		logger.info("***Started TC002_Login****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.lnkAccount();
		logger.info("Clicked On My Account Link In HomePage");
		hp.loginLink();
		logger.info("Clicked On Login Link");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(pr.getProperty("email"));
		lp.setPassword(pr.getProperty("password"));
		lp.loginButton();
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExist();
		Assert.assertTrue(targetpage); //Assert.assertEquals(targetpage, true,"Login Failed");
		macc.logoutLink();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****Finished TC002_Login****");
		}
	
		
	
	}


