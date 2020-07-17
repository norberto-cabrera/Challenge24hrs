package Framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Windows10 {
	WebDriver driver;

	public Windows10(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//nav[@id='uhf-g-nav']/ul/li[2]/div/button")
	WebElement w10;
	
	@FindBy(id="c-shellmenu_51")
	WebElement list1;
	
	@FindBy(id="c-shellmenu_52")
	WebElement list2;
	
	@FindBy(id="c-shellmenu_53")
	WebElement list3;
	
	@FindBy(id="c-shellmenu_54")
	WebElement list4;
	
	@FindBy(id="c-shellmenu_55")
	WebElement list5;
	
	@FindBy(id="c-shellmenu_56")
	WebElement list6;
	
	@FindBy(id="c-shellmenu_57")
	WebElement list7;
	
	@FindBy(id="c-shellmenu_58")
	WebElement list8;
	
	@FindBy(id="c-shellmenu_59")
	WebElement list9;
	
	@FindBy(id="c-shellmenu_60")
	WebElement list10;
	
	@FindBy(id="search")
	WebElement search_b;
	
	@FindBy(id="cli_shellHeaderSearchInput")
	WebElement search_i;
	
	@FindBy(xpath="//div[@id='R1MarketRedirect-1']//button[@class='c-glyph glyph-cancel']")
	WebElement cerrar;
	
	@FindBy(xpath="//span[contains(text(),'$799.00')]")
	WebElement price1;
	
	@FindBy(xpath="//span[contains(text(),'$5,999.00')]")
	WebElement price2;
	
	@FindBy(xpath="//span[contains(text(),'$899.00')]")
	WebElement price3;
	
	
	


	
	public void printing_list ()  {
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(w10));
		wait.until(ExpectedConditions.elementToBeClickable(w10));
		w10.click();
		
		
		wait.until(ExpectedConditions.visibilityOf(list1));
		wait.until(ExpectedConditions.visibilityOf(list2));
		wait.until(ExpectedConditions.visibilityOf(list3));
		wait.until(ExpectedConditions.visibilityOf(list4));
		wait.until(ExpectedConditions.visibilityOf(list5));
		wait.until(ExpectedConditions.visibilityOf(list6));
		wait.until(ExpectedConditions.visibilityOf(list7));
		wait.until(ExpectedConditions.visibilityOf(list8));
		wait.until(ExpectedConditions.visibilityOf(list9));
		wait.until(ExpectedConditions.visibilityOf(list10));
		System.out.println("\nThe list in windows 10 tab is: ");
		System.out.println(list1.getText()+"\r\n"+list2.getText()+"\r\n"+list3.getText()+"\r\n"+list4.getText()+"\r\n"+list5.getText()+"\r\n"+list6.getText()+"\r\n"+list7.getText()+"\r\n"+list8.getText()+"\r\n"+list9.getText()+"\r\n"+list10.getText());
	}
	
	public void searching(String search) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(search_b));
		search_b.click();
		alert_handler.handler(cerrar);
		wait.until(ExpectedConditions.visibilityOf(search_i));
		search_i.sendKeys(search);
		search_i.sendKeys(Keys.ENTER);
		alert_handler.handler(cerrar);
	}
	
	
	public String printing_prices() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String price_1;
		wait.until(ExpectedConditions.visibilityOf(price1));
		wait.until(ExpectedConditions.visibilityOf(price2));
		wait.until(ExpectedConditions.visibilityOf(price3));
		price_1 = price1.getText();
		System.out.println("\nThe prices of the 3 first elements are: ");
		System.out.println(price_1+"\r\n"+price2.getText()+"\r\n"+price3.getText());
		return price_1;
	}
	
	public void select_one() {
		price1.click();
	}
}
