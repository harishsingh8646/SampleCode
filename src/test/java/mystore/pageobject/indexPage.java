package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class indexPage {

	WebDriver ldriver;

	public indexPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void clickOnSignIn() {
		WebElement signIn = ldriver.findElement(By.linkText("Sign in"));
		signIn.click();
	}

	public String getPageTitle() {
		return ldriver.getTitle();
	}

	public void clickOnTShirtMenu() {
		WebElement tshirtMenu = ldriver.findElement(By.xpath("(//a[text()='T-shirts'])[2]"));
		tshirtMenu.click();
	}
}
