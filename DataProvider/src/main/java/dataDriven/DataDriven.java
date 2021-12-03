package dataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDriven 
{
	FirefoxDriver driver;
	@Test(dataProvider="testdata")
	public void DemoProject(String username, String password) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\austi\\OneDrive\\Documents\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.linkedin.com/login");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id=\"app__container\"]/main/div/form/div[3]/button")).click();
		Thread.sleep(5000);
		System.out.println("Login successful");
	}
	
	@AfterMethod
	void ProgramTermination()
	{
		driver.quit();
	}
	
	@DataProvider(name="testdata")
	public Object[][] TestDataFeed()
	{
		ReadExcelFile config = new ReadExcelFile("C:\\Users\\austi\\Desktop\\TestData.xlsx");
		int rows = config.getRowCount(0);
		Object[][] credentials = new Object[rows][2];
		for(int i = 0; i < rows; i++)
		{
			credentials[i][0] = config.getData(0, i, 0);
			credentials[i][1] = config.getData(0, i, 1);
		}
		return credentials;
	}
}