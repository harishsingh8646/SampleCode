package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {
	WebDriver ldriver;

	public OrderConfirmationPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void clickOnSignOut() {
		WebElement signOut = ldriver.findElement(By.linkText("Sign out"));
		signOut.click();
	}

	public void clickOnConfirmOrder() {
		WebElement confirmOrder = ldriver.findElement(By.xpath("//button[@name='btn1']"));
		confirmOrder.click();
	}

	public String getOrderSuccessMessage() {
		WebElement successAlert = ldriver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']"));
		return successAlert.getText();
	}

}
