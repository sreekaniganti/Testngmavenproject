package Tests;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.HomePage;

import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCartFeature {
	
	WebDriver driver;
	public String STORE_URL = "https://www.webstaurantstore.com/";
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(STORE_URL);
	}
	
	@Test
	public void AddItemsAndEmptyCart( ) throws InterruptedException {
		String searchQuery = "stainless work table";
		String word = "table";
		HomePage hPage = new HomePage(driver);
		CartPage cPage = new CartPage(driver);
		
		hPage.setSearchBox(searchQuery);
		hPage.clickSearchButton();
		Thread.sleep(5000);
		
		List<String> titles = hPage.get_title_of_all_search_results();
		for (String title: titles) {
			assertTrue(title.toLowerCase().contains(word), String.format("Title %s don't have word %s in it", title, word));
		}
		
		int count = titles.size();
		hPage.click_add_to_cart_button(count-1, true);
		hPage.click_notification_view_cart_button();
		
		cPage.click_empty_cart_button();
		cPage.click_popup_empty_cart_button();
		Thread.sleep(10000);
		String text = cPage.get_empty_cart_string();
		
		assertTrue(text.equals("Your cart is empty."), "Empty cart message is wrong");
	}
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}

}
