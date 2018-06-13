package maven_pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class my_test {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("hellloo.......");
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("https://test.corepractice.is/#/");
//		    driver.findElement(By.id("Password")).clear();
//		    driver.findElement(By.id("Password")).sendKeys("ShahElsner2018");
//		    driver.findElement(By.id("Username")).clear();
//		    driver.findElement(By.id("Username")).sendKeys("harshal");
//		    driver.findElement(By.xpath("//button[@type='submit']")).click();
//		    Thread.sleep(5000);
//		    driver.findElement(By.xpath("//div[@id='navbar']/ul/li/a/span")).click();
//		    driver.findElement(By.xpath("(//a[contains(text(),'Appointment Book')])[2]")).click();
//		    Thread.sleep(5000);
//		    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
//		    driver.findElement(By.linkText("Default Practice")).click();
//		    Thread.sleep(5000);
//		    driver.findElement(By.xpath("//*[@data-time='09:00:00']")).click();
//		    driver.findElement(By.linkText("Select Patient")).click();
//		    driver.findElement(By.name("Firstname")).clear();
//		    driver.findElement(By.name("Firstname")).sendKeys("harshal");
//		    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
//		    driver.findElement(By.linkText("Mr Harshal Shah")).click();
//		    Thread.sleep(5000);
//		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    driver.quit();
	}

}
