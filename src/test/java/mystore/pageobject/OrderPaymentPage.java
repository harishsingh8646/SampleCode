package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPaymentPage {
	WebDriver ldriver;

	public OrderPaymentPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public String getPageTitle() {
		return ldriver.getCurrentUrl();
	}

	public void clickOnPayByCheque() {
		WebElement payByCheque = ldriver.findElement(By.xpath("//a[@class='chq_pay']"));
		payByCheque.click();
	}

	public void clickOnPayByBankWire() {
		WebElement payByBankWire = ldriver.findElement(By.className("bankwire"));
		payByBankWire.click();
	}
}
