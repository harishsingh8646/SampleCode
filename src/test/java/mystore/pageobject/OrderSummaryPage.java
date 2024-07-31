package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderSummaryPage {

	WebDriver ldriver;

	public OrderSummaryPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void clickOnProceedToCheckout() {
		WebElement proceed = ldriver.findElement(By.linkText("Proceed to checkout"));
		proceed.click();
	}
}
