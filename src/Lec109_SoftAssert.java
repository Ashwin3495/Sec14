import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Lec109_SoftAssert {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> list=driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		
		SoftAssert a =new SoftAssert();
		for(WebElement l1:list) {
		
		//String url=driver.findElement(By.cssSelector("a[href*='brokenlink']")).getAttribute("href");
			String url=l1.getAttribute("href");
		HttpURLConnection conn= (HttpURLConnection)new URL(url).openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode=conn.getResponseCode();
		System.out.println(respCode);
		a.assertTrue(respCode<400,l1.getText());
		
		/*
		if(respCode>400) {
			Assert.assertTrue(false);
		}
		
		}
		
		*/
	}
		a.assertAll();
	}
}
