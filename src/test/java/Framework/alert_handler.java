package Framework;

import org.openqa.selenium.WebElement;

public class alert_handler {

	static void handler(WebElement cerrar) {
		try {
			cerrar.click();
		}
		catch (Exception e) {
			
		}
	}
}
