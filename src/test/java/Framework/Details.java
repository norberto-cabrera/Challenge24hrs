package Framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Details {
	WebDriver driver;

	public Details(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='ProductPrice_productPrice_PriceContainer']//span[contains(text(),'$799.00')]")
	WebElement price;
	
	@FindBy(xpath="//div[3]/div/div/div/button")
	WebElement cart;
	
	@FindBy(xpath="//div[@id='R1MarketRedirect-1']//button[@class='c-glyph glyph-cancel']")
	WebElement cerrar;
	
	
	public void price_validation(String price_ini) {
		alert_handler.handler(cerrar);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(price));
		Assert.assertEquals(price.getText(), price_ini, "Prices are not same");
		System.out.println("\nComparison of prices in Detail page: \n"+"Store price: "+price_ini+"\nPrice in the detail page: "+price.getText());
	}
	
	public void add_cart() {
		/*
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(cart));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart.click();
		
		*/
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", cart);
	}
	

}
