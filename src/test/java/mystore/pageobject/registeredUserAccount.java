package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class registeredUserAccount {

	WebDriver ldriver;

	public registeredUserAccount(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void clickOnSignOut() {
		WebElement signOut = ldriver.findElement(By.linkText("Sign out"));
		signOut.click();
	}

	public String getUserName() {
		WebElement userName = ldriver.findElement(By.xpath("//a[@title='View my customer account']"));
		return userName.getText();
	}

	public void enterDataInSearchBox(String searchKey) {
		WebElement searchBox = ldriver.findElement(By.name("search_query"));
		searchBox.sendKeys(searchKey);
	}

	public void clickOnSearchButton() {
		WebElement submitSearch = ldriver.findElement(By.name("submit_search"));
		submitSearch.click();
	}

	public void mouseOverTShirtMenu() {
		WebElement womenMenu = ldriver.findElement(By.linkText("Women"));
		WebElement tShirtMenu = ldriver.findElement(By.linkText("T-shirts"));
		Actions actions = new Actions(ldriver);
		actions.moveToElement(womenMenu).moveToElement(tShirtMenu).click().perform();
	}
}
