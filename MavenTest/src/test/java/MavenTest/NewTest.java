package MavenTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	JavascriptExecutor js = (JavascriptExecutor) driver;  
	static WebDriver driver;
	@Test(priority = 1)
	public void OpenURL() {
		System.out.println("Open URL");
		driver.get("http://magento-demo.lexiconn.com/customer/account/login/");
	}
	@Test(priority = 2)
	public void LoginWithInvalidData() {
		System.out.println("Login With Invalid Data");
		driver.findElement(By.id("email")).sendKeys("sagar@xhtmljunkies.com");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("123456978");
		driver.findElement(By.id("send2")).click();
	}
	@Test(priority = 3)
	public void LoginWithValidData() {
		System.out.println("Login With Valid Data");
		driver.findElement(By.id("pass")).click();
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@id='send2']/span/span")).click();
	}
	@Test(priority = 4)
	public void OpenCategory() {
		System.out.println("Open Category");
		driver.get("http://magento-demo.lexiconn.com/accessories/eyewear.html");
	}
	@Test(priority = 5)
	public void AddProductInCart() {
		System.out.println("Add Product In Cart");
		driver.findElement(By.xpath("//html[@id='top']/body/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/ul/li/div/div[2]/button/span/span")).click();
	}
	@Test(priority = 6)
	public void RemoveProductFromCart() {
		System.out.println("Remove Product From Cart");
		driver.findElement(By.xpath("//button[@id='empty_cart_button']/span/span")).click();		
	}
	@Test(priority = 7)
	public void AddProductToWishlist() {
		driver.get("http://magento-demo.lexiconn.com/accessories/eyewear.html");
		js.executeScript("window.scrollBy(0,1000)");
		System.out.println("Add Product To Wishlist");
		driver.findElement(By.linkText("Accessories")).click();
		driver.findElement(By.xpath("//img[@alt='Eyewear']")).click();
		driver.findElement(By.linkText("Add to Wishlist")).click();
		driver.switchTo().alert().accept();
	}
	@Test(priority = 8)
	public void RemoveFromWishlist() {
		System.out.println("Remove From Wishlist");
		driver.findElement(By.linkText("Remove item")).click();
		driver.switchTo().alert().accept();
	}
	@Test(priority = 9)
	public void AddToCompare() {
		System.out.println("Add To Compare");
		driver.findElement(By.linkText("Accessories")).click();
		driver.findElement(By.xpath("//img[@alt='Eyewear']")).click();
		driver.findElement(By.linkText("Add to Compare")).click();
		driver.findElement(By.linkText("Sale")).click();
		driver.findElement(By.linkText("Add to Compare")).click();
	}
	@Test(priority = 10)
	public void CheckCompare() {
		System.out.println("Check Compare");
		driver.findElement(By.xpath("//html[@id='top']/body/div/div[2]/div[2]/div/div[3]/div/div[2]/div/button/span/span")).click();
		driver.findElement(By.xpath("//html[@id='top']/body/div/div[2]/button/span/span")).click();
		driver.close();
	}
	@Test(priority = 11)
	public void CheckMyAccount() {
		System.out.println("Check My Account");
		driver.findElement(By.xpath("//header[@id='header']/div/div[2]/a[3]/span[2]")).click();
		driver.findElement(By.linkText("My Account")).click();
	}
	@Test(priority = 12)
	public void RemoveFromCompare() {
		System.out.println("Remove From Compare");
		driver.findElement(By.linkText("Clear All")).click();
		driver.switchTo().alert().accept();
	}
	@Test(priority = 13)
	public void LogOut() {
		System.out.println("Log Out");
		driver.findElement(By.xpath("//header[@id='header']/div/div[2]/a[3]/span[2]")).click();
		driver.findElement(By.linkText("Log Out")).click();		
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Open Browser");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void afterTest() {
		System.out.println("Close Browser");
		driver.quit();
	}

}
