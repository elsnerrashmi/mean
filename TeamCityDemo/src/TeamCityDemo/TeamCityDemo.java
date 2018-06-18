package TeamCityDemo;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TeamCityDemo {
	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		System.out.println("Launching Browser");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver = new ChromeDriver();
		System.out.println("Browser Launch");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:8292/auth/signin");
		System.out.println("Open URL");
		System.out.println("Login with : test@xhtmljunkies.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test@xhtmljunkies.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("1234567");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		System.out.println("Login Validition Error: "+driver.findElement(By.xpath("//p[contains(.,'Credentials do not match with our records.')]")).getText());
		driver.findElement(By.xpath("//button[contains(.,'Close')]")).click();
		driver.get("http://localhost:8292/auth/signin");
		System.out.println("Login with : sagar@xhtmljunkies.com");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sagar@xhtmljunkies.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		System.out.println("Login Successfully" + driver.findElement(By.xpath("//input[@id='text']")).getText());
		driver.quit();
	}

}
