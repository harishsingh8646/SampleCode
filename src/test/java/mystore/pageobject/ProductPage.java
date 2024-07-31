package mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {

	WebDriver ldriver;

	public ProductPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

	public void setQuantity(String qty) {
		WebElement quantityWanted = ldriver.findElement(By.id("quantity_wanted"));
		quantityWanted.clear();
		quantityWanted.sendKeys(qty);
	}

	public void setSize(String sizeType) {
		WebElement size = ldriver.findElement(By.id("group_1"));
		Select oSelect = new Select(size);
		oSelect.selectByVisibleText(sizeType);
	}

	public void clickOnAddToCart() {
		WebElement addToCart = ldriver.findElement(By.name("Submit"));
		addToCart.click();
	}

	public void clickOnProceedToCheckOut() {
		WebElement proceed = ldriver.findElement(By.linkText("Proceed to checkout"));
		proceed.click();
	}

	public void mouseOverOnTshirtProduct() {
		WebElement tshirtProduct = ldriver.findElement(By.xpath("//a[contains(.,'Faded Short Sleeve T-shirts')]"));
		Actions actionobj = new Actions(ldriver);
		actionobj.moveToElement(tshirtProduct).build().perform();
	}

	public void clickOnAddToWishList() {
		WebElement addToWishList = ldriver.findElement(By.xpath("//a[@class='addToWishlist wishlistProd_1']"));
		addToWishList.click();
	}

	public String getTextOfAlertForWishList() {
		WebElement alertForAddToWishList = ldriver.findElement(By.xpath("//p[@class='fancybox-error']"));
		return alertForAddToWishList.getText();
	}
}
