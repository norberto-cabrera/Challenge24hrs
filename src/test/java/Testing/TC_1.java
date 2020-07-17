package Testing;

import org.testng.annotations.Test;

import Framework.BaseClass;
import Framework.Details;
import Framework.HomePage;
import Framework.Windows10;
import Framework.summary;

public class TC_1 extends BaseClass{
	
	@Test
	public void TC_Microsoft_Navigation() {
		
		HomePage HP = new HomePage(driver);
		HP.menu_validation(config_data[2], config_data[3], config_data[4], config_data[5], config_data[6], config_data[7]);
		HP.goto_windows();
		
		Windows10 w10 = new Windows10(driver);
		w10.printing_list();
		w10.searching(config_data[8]);
		String price = w10.printing_prices();
		w10.select_one();
		
		Details det = new Details(driver);
		det.price_validation(price);
		det.add_cart();
		
		summary sum = new summary(driver);
		sum.price_verification();
		sum.total_amount_20times();
		
	}

}
