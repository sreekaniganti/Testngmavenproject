package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By searchBox = By.id("searchval");
	By searchButton = By.xpath("//*[@id=\"searchForm\"]/div/button");
	By firstitem = By.xpath("//*[@id=\"ProductBoxContainer\"][1]");
	By itemTiles = By.xpath("//*[@id=\"details\"]//*[@data-testid=\"itemDescription\"]");
	By addCartBtns = By.xpath("//input[@name=\"addToCartButton\"]");
	By notificationViewCartBtn =  By.xpath("//*[@id=\"watnotif-wrapper\"]//a[@href=\"/viewcart.cfm\"]");
	
	public void setSearchBox(String query) {
		WebElement element = driver.findElement(searchBox);
		UtilityMethods.wait_for_element_to_appear(driver, element);
		element.sendKeys(query);
	}
	
	public void clickSearchButton() {
		driver.findElement(searchButton).click();
	}
	
	public List<String> get_title_of_all_search_results() {
		List<String> text = new ArrayList<String>();
		List<WebElement> elements = driver.findElements(itemTiles);
		for (WebElement ele : elements) { text.add(ele.getText()); }
		return text;
	} 
	
	public void click_add_to_cart_button(int index, Boolean scrollIntoView) {
		WebElement element = driver.findElements(addCartBtns).get(index);
		if (scrollIntoView) { UtilityMethods.scroll_into_view(driver, element); }
		element.click();
	}
	
	public void click_notification_view_cart_button() {
		WebElement element = driver.findElement(notificationViewCartBtn);
		UtilityMethods.wait_for_element_to_appear(driver, element);
		element.click();
	}

}
