package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderAddressPage {

	WebDriver ldriver;

	public OrderAddressPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void clickOnProceedToCheckout() {
		WebElement proceedfromAddressPage = ldriver.findElement(By.name("processAddress"));
		proceedfromAddressPage.click();
	}
}
