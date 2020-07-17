package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class summary {
	WebDriver driver;
	Select dropdown; 
	String price1_s;
	String price2_s;
	String price3_s;
	String total_s;
	

	public summary(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//div[@class='item-price']//div//span[@class='c-price']//span//span[contains(text(),'$799.00')]")
	WebElement price1;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[1]/div[1]/span[1]/span[2]/div[1]/span[1]/span[2]/span[1]")
	WebElement price2;
	
	@FindBy(xpath="/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/section[2]/div[1]/div[1]/div[2]/div[1]/span[1]/span[2]/strong[1]/span[1]")
	WebElement price3;
	
	@FindBy(xpath="//span[@class='_3fnVqdke c-paragraph-4']//span//strong//span[contains(text(),'$15,980.00')]")
	WebElement total_;
	
	@FindBy(xpath="//div[@class='item-quantity']//select")
	WebElement select;
	

	public void price_verification() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(price1));
		wait.until(ExpectedConditions.visibilityOf(price2));
		wait.until(ExpectedConditions.visibilityOf(price3));
		
		price1_s=price1.getText();
		price2_s=price2.getText();
		price3_s=price3.getText();
		
		System.out.println("\nThe 3 prices for the same product are: \n"+price1_s);
		System.out.println(price2_s);
		System.out.println(price3_s);
		
		Assert.assertEquals(price1_s, price2_s);
		Assert.assertEquals(price1_s, price3_s);
		Assert.assertEquals(price2_s, price3_s);
	}
	
	public void total_amount_20times() {
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(select));
		dropdown = new Select(select);
		dropdown.selectByValue("20");
		
		wait.until(ExpectedConditions.visibilityOf(total_));
		total_s = total_.getText();
		System.out.println("\nTotal price by selecting 20 items: " + total_s);
		price1_s = price1_s.replaceAll("[$,]", "");
		total_s = total_s.replaceAll("[$,]", "");
		double price_d = Double.parseDouble(price1_s);
		double total_d = Double.parseDouble(total_s);
		
		double total = price_d * 20; 
		System.out.println("\nAfter conversion taking out $ dollar sign:");
		System.out.println("Price by unit: "+price_d);
		System.out.println("Price for 20 items: "+total_d+" (from page)");
		System.out.println("Price for 20 items: "+total+" (Calculation based on the unit price * 20)");
		Assert.assertEquals(total, total_d);
	}
}
