package corepractice;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class corepractice {

	public static void main(String[] args) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://test.corepractice.is");
		  //*******************login with invalid data and then valid data**********
		 //  String uname[]= {"","%^@@@","John","harshal"};
		 // String pwd[]= {"","8&*-+++78$%","JohnMarkFriend","ShahElsner2018"};
		  String uname[]= {"harshal"};
		  String pwd[]= {"ShahElsner2018"}; 
		  for(int i=0;i<uname.length;i++)
		  {
		   driver.findElement(By.name("Username")).clear();
		   driver.findElement(By.name("Password")).clear();
		   System.out.println(uname[i]+"  "+pwd[i]);
		   driver.findElement(By.name("Username")).sendKeys(uname[i]);
		   Thread.sleep(1000);
		   driver.findElement(By.name("Password")).sendKeys(pwd[i]);
		   Thread.sleep(1000);
		   //driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/form/button")).click();
		   //driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		   //driver.findElement(By.xpath("//*[@class='btn btn-primary btn-block']")).click();
		    driver.findElement(By.xpath("//*[@type='submit']")).click();
		   Thread.sleep(2000);
		  }
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click(); // click menu
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//*[@href='/my/#/appointments']")).click(); // click submenu
		  Thread.sleep(5000);
		  driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click(); // click menu
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@href='/my/#/appointments']")).click(); // click submenu
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@ui-sref='appointment.book.slotfinder']")).click();
		  Thread.sleep(2000);
		  WebElement d1 =driver.findElement(By.xpath("//*[@id='Start']"));
		  d1.clear();d1.sendKeys("11:00");
		  
		  
		  //driver.findElement(By.xpath("//*[@ui-sref='appointment.book.patient']")).click(); 
		  //Thread.sleep(5000);
		 // WebElement keys=driver.findElement(By.xpath("//span[contains(.,'Find existing')]"));
//		  Robot r=new Robot();
//		  r.keyPress(KeyEvent.VK_SHIFT);
//		  r.keyPress(KeyEvent.VK_TAB);
//		  r.keyRelease(KeyEvent.VK_TAB);
//		  r.keyRelease(KeyEvent.VK_SHIFT);
//		  r.keyPress(KeyEvent.VK_ENTER);
//		  
		  
		

	}

}
