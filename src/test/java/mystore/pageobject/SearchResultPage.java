package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage {

	WebDriver ldriver;

	public SearchResultPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public String getSearchResultProductName() {
		WebElement searchResultProduct = ldriver.findElement(By.xpath("//a[@title='product_name']"));
		return searchResultProduct.getText();
	}

	public void clickOnMoreLink() {
		WebElement more = ldriver.findElement(By.linkText("More"));
		more.click();
	}
}
