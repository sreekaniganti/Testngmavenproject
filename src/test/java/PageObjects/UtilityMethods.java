package PageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityMethods {
	
	public static Duration BASE_TIMEOUT = Duration.ofSeconds(15);
	
	public static void wait_for_element_to_appear(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void wait_for_element_to_disappear(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public static void wait_for_element_to_be_clickable(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, BASE_TIMEOUT);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void scroll_into_view(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
}
