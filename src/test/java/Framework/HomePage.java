package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="shellmenu_1")
	WebElement OfficeL;
	
	@FindBy(id="shellmenu_2")
	WebElement WindowsL;
	
	@FindBy(id="shellmenu_3")
	WebElement SurfaceL;
	
	@FindBy(id="shellmenu_4")
	WebElement XboxL;
	
	@FindBy(id="shellmenu_5")
	WebElement DealsL;
	
	@FindBy(id="l1_support")
	WebElement SupportL;
	
	
	public void menu_validation(String Office, String Windows, String Surface, String Xbox, String Deals, String Support) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(OfficeL));
		Assert.assertEquals(OfficeL.getText(), Office, "The item: " +Office+ " is not Present.");
		
		wait.until(ExpectedConditions.visibilityOf(WindowsL));
		Assert.assertEquals(WindowsL.getText(), Windows, "The item: " +Windows+ " is not Present.");
		
		wait.until(ExpectedConditions.visibilityOf(SurfaceL));
		Assert.assertEquals(SurfaceL.getText(), Surface, "The item: " +Surface+ " is not Present.");
		
		wait.until(ExpectedConditions.visibilityOf(XboxL));
		Assert.assertEquals(XboxL.getText(), Xbox, "The item: " +Xbox+ " is not Present.");
		
		wait.until(ExpectedConditions.visibilityOf(DealsL));
		Assert.assertEquals(DealsL.getText(), Deals, "The item: " +Deals+ " is not Present.");
		
		wait.until(ExpectedConditions.visibilityOf(SupportL));
		Assert.assertEquals(SupportL.getText(), Support, "The item: " +Support+ " is not Present.");
				
	}
	
	public void goto_windows() {
		WindowsL.click();
	}
	
	
	
	
	

}
