package mystore.testcases;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccountPage;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadExcelFile;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;


public class TC_MyAccountDataDrivenTesting extends BaseClass {


	@Test
	public void verifyRegistrationAndLogin()
	{

		logger.info("***************TestCase Verify Registration and Login starts*****************"); 

		indexPage pg = new indexPage(driver);
		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);
		myAcpg.enterCreateEmailAddress("daniel@yopmail.com");
		logger.info("Email address entered in create account section.");

		myAcpg.clickSubmitCreate();

		logger.info("clicked on create an account button");

		accountCreationDetails accCreationPg = new accountCreationDetails(driver);

		accCreationPg.selectTitleMrs();
		accCreationPg.enterCustomerFirstName("Harish");
		accCreationPg.enterCustomerLastName("Singh");
		accCreationPg.enterPassword("cs923");
		accCreationPg.enterAddressFirstName("Harish");
		accCreationPg.enterAddressLastName("Singh");
		accCreationPg.enterAddress("18/8 street road");

		accCreationPg.enterCity("Delhi");
		accCreationPg.selectState("Delhi");

		accCreationPg.enterPostcode("00000");
		accCreationPg.selectCountry("India");
		accCreationPg.enterMobilePhone("8527247846");
		accCreationPg.enterAlias("Home");

		logger.info("entered user details on account creation page.");

		accCreationPg.clickOnRegister();
		logger.info("clicked on Register button");

		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();

		Assert.assertEquals("Harish Singh", userName);

		logger.info("***************TestCase Verify Registration and Login ends*****************"); 

	}
	
	@Test(dataProvider = "LoginDataProvider")
	
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
	{

		logger.info("***************TestCase VerifyLogin starts*****************"); 


		indexPage pg = new indexPage(driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccountPage myAcpg = new myAccountPage(driver);

		myAcpg.enterEmailAddress(userEmail);
		logger.info("Entered email address");
		
		myAcpg.enterPassword(userPwd);
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");

		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();
		
		
		if(userName.equals(expectedUsername))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			
			regUser.clickOnSignOut();
			
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		} 
		
		 
		logger.info("***************TestCase Verify login ends*****************"); 


	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)
		{
			for(int j=0;j<ttlColumns;j++)
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}
















































