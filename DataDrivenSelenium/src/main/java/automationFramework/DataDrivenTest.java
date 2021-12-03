package automationFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	WebDriver driver;
	WebDriverWait wait;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	HSSFCell cell;
	
	@BeforeTest
	public void TestSetup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\austi\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.linkedin.com/login");
		driver.manage().window().maximize();
		
		wait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void ReadData() throws IOException{
		//Import excel sheet
		File src = new File("C:\\Users\\austi\\Desktop\\TestData.xlsx");
		
		//load the file
		FileInputStream finput = new FileInputStream(src);
		
		//load the workbook
		workbook = new HSSFWorkbook(finput);
		
		//load the sheet in which data is stored
		sheet = workbook.getSheetAt(0);
		
		for(int i = 1; i == sheet.getLastRowNum(); i++) {
			//import data for email
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(CellType.STRING);		
			driver.findElement(By.id("username")).sendKeys(cell.getStringCellValue());
			
			//import data for password
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(CellType.STRING);
			driver.findElement(By.id("password")).sendKeys(cell.getStringCellValue());			
			
		}
	}
}