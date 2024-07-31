package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class myAccountPage {

	WebDriver ldriver;

	public myAccountPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void enterCreateEmailAddress(String emailAdd) {
		WebElement createEmailId = ldriver.findElement(By.id("email_create"));
		createEmailId.sendKeys(emailAdd);
	}

	public void clickSubmitCreate() {
		WebElement submitCreate = ldriver.findElement(By.id("SubmitCreate"));
		submitCreate.click();
	}

	//ACTIONS METHODS FOR ALREADY REGISTERED USERS
	public void enterEmailAddress(String emailAdd) {
		WebElement registeredUsersEmail = ldriver.findElement(By.id("email"));
		registeredUsersEmail.sendKeys(emailAdd);
	}

	public void enterPassword(String pwd) {
		WebElement registeredUsersPwd = ldriver.findElement(By.id("passwd"));
		registeredUsersPwd.sendKeys(pwd);
	}

	public void clickSignIn() {
		WebElement submitLogin = ldriver.findElement(By.id("SubmitLogin"));
		submitLogin.click();
	}
}
