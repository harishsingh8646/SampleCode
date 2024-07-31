package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderShippingPage {

	WebDriver ldriver;

	public OrderShippingPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void selectTermsOfServices() {
		WebElement termOfServices = ldriver.findElement(By.id("cgv"));
		termOfServices.click();
	}

	public void clickOnProceedToCheckout() {
		WebElement proceedShipping = ldriver.findElement(By.name("processCarrier"));
		proceedShipping.click();
	}
}
