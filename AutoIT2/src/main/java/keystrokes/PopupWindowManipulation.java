package keystrokes;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupWindowManipulation {
	private static WebDriver driver = null;
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\austi\\OneDrive\\Documents\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.linkedin.com//login");
		
		Runtime.getRuntime().exec("C:\\AutoIT Demo\\keystrokes");
		
		Thread.sleep(5000);
		
		driver.close();
	}

}