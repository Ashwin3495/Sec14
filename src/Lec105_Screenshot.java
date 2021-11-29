import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Lec105_Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//Take screenshot and kill the process
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

			driver.get("https://rahulshettyacademy.com/AutomationPractice/");
			
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src,new File("C://Users//E245979//Desktop//Selenium//screen.png"));
		

	}

}
