package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	void test_account_Registration()
	{  
		logger.info("*****Starting TC_001AccountRegistrationTest**** ");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account link");
		hp.clickRegister();
		logger.info("Clicked on My Register link");
		
		AccountRegistrationPage regpage =new AccountRegistrationPage(driver);
		logger.info("Providing Customer data");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setTelephone(randomeNumber());
		String password=randomeAlphaNumeric();
		regpage.setPassword(password);
     	regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Clicked Continue");
		String confmsg=regpage.getConfirmationMsg();
		logger.info("Validating expected message");
		Assert.assertEquals(confmsg, "Your Account Has Been Created!",("not getting expected message"));
		}catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("*****Finished TC_001AccountRegistrationTest****");
		
	}
	
	
	
}
