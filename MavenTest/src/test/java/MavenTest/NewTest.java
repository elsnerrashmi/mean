package MavenTest;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	static WebDriver driver;
  @Test(priority = 1)
  public void OpenBrowser() {
	  driver.get("http://localhost:8292/auth/signin");
	  driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@xhtmljunkies.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567");
		driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
  }
  @Test(priority = 2)
  public void ValiditionError() throws Exception {
	  	Thread.sleep(2000);
		System.out.println("Login Validition Error: "+driver.findElement(By.xpath("//p[contains(.,'Credentials do not match with our records.')]")).getText());
		driver.findElement(By.xpath("//button[contains(.,'Close')]")).click();

  }
   @Test(priority = 3)
  public void LoginSuccessfully() {
	  driver.get("http://localhost:8292/auth/signin");
		System.out.println("Login with : sagar@xhtmljunkies.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sagar@xhtmljunkies.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		System.out.println("Login Successfully" + driver.findElement(By.xpath("//input[@id='text']")).getText());
  }
  @BeforeTest
  public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Browser Launch");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
