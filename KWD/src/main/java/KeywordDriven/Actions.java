package KeywordDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Actions
{
	public static WebDriver driver;
	
	@Test
	public static void input_Username()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\austi\\OneDrive\\Documents\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.linkedin.com/login");
		driver.findElement(By.id("username")).sendKeys("cody_blackwell@hotmail.com");
	}
	
	public static void input_Password()
	{
		driver.findElement(By.name("password")).sendKeys("test1234");
	}
	
	public static void click_Login()
	{
		driver.findElement(By.name("login")).click();
	}
	
	public static void closeBrowser()
	{
		driver.quit();
	}
}