package Framework;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	protected WebDriver driver;
	ScreenShot screen = new ScreenShot();
	protected String[] config_data = new String[6];
	
	@BeforeMethod
	public void setup() {
		Confi_File config = new Confi_File();
		config_data = config.ReadFile();
		//Browser Creation
		driver = BrowserFactory.StartBrowser(config_data[0], config_data[1]);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.SUCCESS==result.getStatus()) {
			try {
				screen.Screenshot(driver, "SUCCESSFUL", result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(ITestResult.FAILURE==result.getStatus()) {
			try {
				screen.Screenshot(driver, "FAILED", result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		BrowserFactory.QuitBrowser(driver);
	}
}

