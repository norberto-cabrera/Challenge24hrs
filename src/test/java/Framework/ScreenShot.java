package Framework;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	String path = "src/main/resources/ScreenShots/";
	LocalDateTime time = LocalDateTime.now(); 
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH_mm_ss");
	String DateTime = time.format(formatter);
    
	
	public void Screenshot(WebDriver driver, String status, String tc) throws IOException{
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(path + status + "_" +  tc +"_" + DateTime + ".jpg"));
	}
}
