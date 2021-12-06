package hybriddriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Actions {

	@Test
	public static void input_Username()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\austi\\OneDrive\\Documents\\geckodriver.exe");
		WebDriver driver = (WebDriver) new FirefoxDriver();
		driver.get("https://www.linkedin.com/login");
		driver.findElement(By.id("username")).sendKeys("test@gmail.com");
	}
}
