package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePageObject{
	
	//constructor:
	public RegisterPage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators:
   @FindBy(xpath="//input[@id='input-firstname']")
   WebElement txtfirstName;
   @FindBy(xpath="//input[@id='input-lastname']") 
   WebElement txtlastName;
   @FindBy(xpath="//input[@id='input-email']")  
   WebElement txtEmail;
   @FindBy(xpath="//input[@id='input-telephone']")
   WebElement txtTelephone;
   @FindBy(xpath="//input[@id='input-password']")
   WebElement txtPassword;
   @FindBy(xpath="//input[@id='input-confirm']") 
   WebElement txtPasswordConfirm;
   @FindBy(xpath="//input[@name='agree']")  
   WebElement chckAgree;
   @FindBy(xpath="//input[@value='Continue']")
   WebElement btnCntnue;
   @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
   WebElement acntCreation;
  
   //action methods:
   public void setFirstName(String firstname)
   {
	   txtfirstName.sendKeys(firstname);
   }
   public void setLastName(String lastname)
   {
	   txtlastName.sendKeys(lastname);
   }
   public void setEmail(String email)
   {
	   txtEmail.sendKeys(email);
   }
   public void setTelephone(String telephone)
   {
	   txtTelephone.sendKeys(telephone);
   }
   public void setPassword(String password)
   {
	   txtPassword.sendKeys(password);
   }
   public void setConfirmPassword(String confirmpassword)
   {
	   txtPasswordConfirm.sendKeys(confirmpassword);
   }
   public void agree()
   {
	   chckAgree.click();
   }
   public void btncontinue()
   {
	   btnCntnue.click();

   }
   public String accountCreation()
   {
	      try
	      {
	    	  return(acntCreation.getText());
	      }
	    catch(Exception e)
	      {
	    	return(e.getMessage());
	      }
   }
}
