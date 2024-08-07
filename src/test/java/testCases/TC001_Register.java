package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_Register extends BaseClass{
	
	
	@Test(groups= {"sanity","master"})
	public void registerAccount()
	{
	 try
	 {
	    logger.info("*****Starting the TC001_Register***** ");
		HomePage hp=new HomePage(driver);
		hp.lnkAccount();
		logger.info("Clicked On Account Link");
		hp.lnkRegister();
		logger.info("Clicked On Register Link");
		RegisterPage regpage=new RegisterPage(driver);
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeNumber().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		String password=randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.agree();
		regpage.btncontinue();
		logger.info("****Validating expected message****");
		String text=regpage.accountCreation();
		if(text.equals("Your Account Has Been Created!"))
		{
			  Assert.assertTrue(true);
		}
		else
		{
			
			logger.error("*****Failed the testCase*****");
			Assert.assertTrue(false);
		}
		
		
	}
	catch(Exception e)
	 {
		  Assert.fail();
	 }
	 logger.info("****Ended the TC001_Register*****");      
	}
}
