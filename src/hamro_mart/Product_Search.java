package hamro_mart;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Search {
	
	public WebDriver driver;
	public String url = "https://mart-uat.hamrostack.com/";
	WebDriverWait wait;
	
	@BeforeSuite(alwaysRun = true)
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
	}
	@Test
	public void Search() {
		WebElement searchBar = driver.findElement(By.xpath("//div[@id='search']//input[@placeholder='Search products here...']"));
		searchBar.sendKeys("peak shoes");
		WebElement searchButton = driver.findElement(By.xpath("//div[@id='search']//button[@type='submit']"));
		searchButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Peak shoes']")));
	}
	@AfterSuite(alwaysRun = true)
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}
	
}
