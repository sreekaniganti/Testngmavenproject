package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By emptyCartBtn = By.cssSelector("button.emptyCartButton");
	By popupEmptyCartBtn = By.xpath("//footer//button[@type='button'][1]");
	By emptyCartText = By.xpath("//p[@class='header-1']");
	
	public void click_empty_cart_button() {
		WebElement element = driver.findElement(emptyCartBtn);
		UtilityMethods.wait_for_element_to_be_clickable(driver, element);
		element.click();
	}
	
	public void click_popup_empty_cart_button() {
		WebElement element = driver.findElement(popupEmptyCartBtn);
		UtilityMethods.wait_for_element_to_be_clickable(driver, element);
		element.click();
	}
	
	public String get_empty_cart_string() {
		WebElement element = driver.findElement(emptyCartText);
		UtilityMethods.wait_for_element_to_appear(driver, element);
		return element.getText();
	}

}
