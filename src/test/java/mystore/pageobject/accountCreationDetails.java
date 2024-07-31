package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

	WebDriver ldriver;

	public accountCreationDetails(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void selectTitleMrs() {
		WebElement titleMrs = ldriver.findElement(By.id("id_gender2"));
		titleMrs.click();
	}

	public void selectTitleMr() {
		WebElement titleMr = ldriver.findElement(By.id("id_gender1"));
		titleMr.click();
	}

	public void enterCustomerFirstName(String fname) {
		WebElement custfirstName = ldriver.findElement(By.id("customer_firstname"));
		custfirstName.sendKeys(fname);
	}

	public void enterCustomerLastName(String lname) {
		WebElement custlastName = ldriver.findElement(By.id("customer_lastname"));
		custlastName.sendKeys(lname);
	}

	public void enterPassword(String pwd) {
		WebElement password = ldriver.findElement(By.id("passwd"));
		password.sendKeys(pwd);
	}

	public void enterAddressFirstName(String fname) {
		WebElement addFirstname = ldriver.findElement(By.id("firstname"));
		addFirstname.clear();
		addFirstname.sendKeys(fname);
	}

	public void enterAddressLastName(String lname) {
		WebElement addLastname = ldriver.findElement(By.id("lastname"));
		addLastname.clear();
		addLastname.sendKeys(lname);
	}

	public void enterAddress(String address) {
		WebElement address1 = ldriver.findElement(By.id("address1"));
		address1.sendKeys(address);
	}

	public void enterCity(String cityName) {
		WebElement city = ldriver.findElement(By.id("city"));
		city.sendKeys(cityName);
	}

	public void selectState(String text) {
		WebElement state = ldriver.findElement(By.id("id_state"));
		Select obj = new Select(state);
		obj.selectByVisibleText(text);
	}

	public void enterPostcode(String postcodeData) {
		WebElement postcode = ldriver.findElement(By.id("postcode"));
		postcode.sendKeys(postcodeData);
	}

	public void selectCountry(String text) {
		WebElement country = ldriver.findElement(By.id("id_country"));
		Select obj = new Select(country);
		obj.selectByVisibleText(text);
	}

	public void enterMobilePhone(String mobile) {
		WebElement phone_mobile = ldriver.findElement(By.id("phone_mobile"));
		phone_mobile.sendKeys(mobile);
	}

	public void enterAlias(String text) {
		WebElement alias = ldriver.findElement(By.id("alias"));
		alias.clear();
		alias.sendKeys(text);
	}

	public void clickOnRegister() {
		WebElement register = ldriver.findElement(By.id("submitAccount"));
		register.click();
	}
}
