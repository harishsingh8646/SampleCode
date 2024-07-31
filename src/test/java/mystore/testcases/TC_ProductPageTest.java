package mystore.testcases;

import com.mystore.pageobject.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;



public class TC_ProductPageTest  extends BaseClass  {

	@Test
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "T-shirts";
		logger.info("\n***************TestCase Search Product started*****************"); 

		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnSignIn();

		myAccountPage pg = new myAccountPage(driver);
		pg.enterEmailAddress(emailAddress);

		logger.info("User Email and Password entered.");
		pg.enterPassword(password);

		pg.clickSignIn();
		logger.info("Sign In link clicked");

		registeredUserAccount productPg = new registeredUserAccount(driver);
		productPg.enterDataInSearchBox(searchKey);
		productPg.clickOnSearchButton();

		SearchResultPage resultPg = new SearchResultPage(driver);

		String SearchResultProductname=resultPg.getSearchResultProductName();

		if(SearchResultProductname.contains(searchKey))
		{
			logger.info("Search Product testcase - Passed"); 
			Assert.assertTrue(true);

			productPg.clickOnSignOut();

		}
		else
		{
			logger.info("Search Product testcase - Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase Search Product ends*****************"); 

	}


	@Test(enabled = true)
	public void VerifyBuyProduct() throws IOException
	{

		logger.info("\n***************TestCase Buy Product started*****************"); 

		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnSignIn();


		//Enter account details- email and password
		myAccountPage pg = new myAccountPage(driver);
		pg.enterEmailAddress(emailAddress);

		logger.info("User Email and Password entered.");
		pg.enterPassword(password);

		pg.clickSignIn();
		logger.info("Sign In link clicked");

		registeredUserAccount prodCatPg = new registeredUserAccount(driver);
		prodCatPg.enterDataInSearchBox("T-shirts");
		logger.info("T-shirt entered in search box");

		prodCatPg.clickOnSearchButton();
		logger.info("clicked on search button");

		SearchResultPage searchResultPg = new SearchResultPage(driver);
		searchResultPg.clickOnMoreLink();
		logger.info("Clicked on more button");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		ProductPage prodPg = new ProductPage(driver);
		prodPg.setQuantity("2");
		logger.info("quantity 2 entereed");

		prodPg.setSize("M");
		logger.info("size M entered");

		prodPg.clickOnAddToCart();
		logger.info("Clicked on add to cart");

		prodPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on product page");


		OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
		orderSumPg.clickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order summary page");

		OrderAddressPage orderAddPg = new OrderAddressPage(driver);
		orderAddPg.clickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order address page");

		OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
		orderShippingPg.selectTermsOfServices();
		logger.info("selecged term of service check box");

		orderShippingPg.clickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order shipping page");

		OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
		logger.info(orderPaymentPg.getPageTitle());

		orderPaymentPg.clickOnPayByCheque();
		logger.info("Clicked on pay by cheque");

		OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
		orderConfirmPg.clickOnConfirmOrder();

		logger.info("Clicked on confirmed order");

		String sucessMsg = orderConfirmPg.getOrderSuccessMessage();

		if(sucessMsg.equals("Your order on My Store is complete."))
		{
			logger.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);

			orderConfirmPg.clickOnSignOut();

		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenShot(driver,"VerifyBuyProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase BuyProduct ends*****************"); 

	}


	@Test
	public void verifyAddToWishlistWithoutLogin() throws IOException
	{
		logger.info("\n***************TestCase verifyAddToWishlistWithoutLogin started*****************"); 

		indexPage indexPage = new indexPage(driver);
		indexPage.clickOnTShirtMenu();

		ProductPage prodPage = new ProductPage(driver);
		prodPage.mouseOverOnTshirtProduct();

		prodPage.clickOnAddToWishList();

		String actualAlertMsg = prodPage.getTextOfAlertForWishList();
		String expectedAlertMsg = "You must be logged in to manage your wishlist.";

		if(actualAlertMsg.equals(expectedAlertMsg))
		{
			logger.info("verifyAddToWishlistWithoutLogin - passed"); 
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verifyAddToWishlistWithoutLogin - failed"); 
			captureScreenShot(driver,"verifyAddToWishlistWithoutLogin");
			Assert.assertTrue(false);
		}

	}
}
