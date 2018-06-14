package maven_pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class my_test {
	
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("hellloo.......");
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	//	System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("test-type");
//		chromeOptions.addArguments("start-maximized");
//		chromeOptions.addArguments("--disable-extensions");
//		chromeOptions.addArguments("no-sandbox");
//
//		driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		System.out.println("Open");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("send URL");
		 driver.get("http://magento-demo.lexiconn.com/customer/account/create/");
		 driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("rashmi");
		 driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("jain");
		 driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("rashmi1@xhtmljunkies.com");
		 driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
		 driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
		 driver.findElement(By.xpath("//button[@title='Register']")).click();
		 driver.quit();
	}

}
