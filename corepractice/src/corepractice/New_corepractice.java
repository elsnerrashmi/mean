package corepractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class New_corepractice {
	static WebDriver driver;
	static Robot r;
	public static void main(String[] args) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://test.corepractice.is/");
		Thread.sleep(1000);
		r=new Robot();
		login(driver);
		//add_new_patient(driver);
		find_patient(driver);     //done
		select_time(driver);		//done
		
		// create on fun for appointment_without_patient
		

	}
	public static void select_time_without_patient(WebDriver driver)throws Exception
	{
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click(); // click menu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@href='/my/#/appointments']")).click(); // click submenu
		Thread.sleep(1000);
		select_time(driver);
	}
	public static void login(WebDriver driver) throws InterruptedException
	{
		//*******************login with invalid data and then valid data**********
	//  String uname[]= {"","%^@@@","John","harshal"};
	//	String pwd[]= {"","8&*-+++78$%","JohnMarkFriend","ShahElsner2018"};
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
		
	}
	public static void add_new_patient(WebDriver driver) throws InterruptedException, Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click(); // click menu
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@href='/my/#/appointments']")).click(); // click submenu
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@ui-sref='appointment.book.patient']")).click(); // click on right link "select patient
		Thread.sleep(5000);
		
		r.keyPress(KeyEvent.VK_SHIFT);
	    r.keyPress(KeyEvent.VK_TAB);
	    r.keyRelease(KeyEvent.VK_TAB);
	    r.keyRelease(KeyEvent.VK_SHIFT);
	    r.keyPress(KeyEvent.VK_ENTER);
	    Thread.sleep(2000);
		//************** Form fill ups
		//driver.findElement(By.xpath("//*[@class='form-control ptr ng-pristine ng-valid ng-touched']")).click(); 
	    driver.findElement(By.xpath("//*[@id='Title']")).sendKeys("m");
//		driver.findElement(By.id("Title")).click();
//		Thread.sleep(2000);
//		new Select(driver.findElement(By.id("Title"))).selectByVisibleText("Miss");
//		Thread.sleep(2000);
//	    driver.findElement(By.xpath("//option[@value='Master']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//div[2]/div/label")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.id("Firstname")).click();
	    driver.findElement(By.id("Firstname")).clear();
	    driver.findElement(By.id("Firstname")).sendKeys("Urvashi");
	    driver.findElement(By.id("Lastname")).clear();
	    driver.findElement(By.id("Lastname")).sendKeys("Jethva");
	    driver.findElement(By.xpath("(//input[@name='Mobile'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@name='Mobile'])[2]")).sendKeys("1234-567-899");
	    driver.findElement(By.xpath("(//input[@name='Mobile'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@name='Mobile'])[2]")).sendKeys("1234-567-899");
	    driver.findElement(By.xpath("(//button[@type='button'])[24]")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[24]")).click();
	    driver.findElement(By.xpath("(//button[@type='button'])[32]")).click();
	    driver.findElement(By.xpath("(//input[@name='Email'])[2]")).click();
	    driver.findElement(By.xpath("(//input[@name='Email'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@name='Email'])[2]")).sendKeys("test@gmail.com");
	    driver.findElement(By.id("AddressLine1")).click();
	    driver.findElement(By.id("AddressLine1")).clear();
	    driver.findElement(By.id("AddressLine1")).sendKeys("321 Test");
	    driver.findElement(By.xpath("//div[@id='Suburb']/div/span")).click();
	    driver.findElement(By.xpath("//div[@id='Postcode']/div/span/span")).click();
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).clear();
	    driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("3");
	    driver.findElement(By.xpath("//div[@id='ui-select-choices-row-4-1']/span/span")).click();
	    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
		
		
		
		
		
		/*
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.xpath("//*[@class='form-control ptr ng-pristine ng-valid ng-touched']")).sendKeys("Mrs");
		
		//driver.findElement(By.xpath("//*[@class='btn btn-default ng-pristine ng-untouched ng-valid'][@value='M']")).click(); // both are workingjust change  M/F
		driver.findElement(By.xpath("//*[@class='btn btn-default ng-pristine ng-untouched ng-valid' and @value='M']")).click();
		driver.findElement(By.xpath("//*[@id='Firstname']")).sendKeys("fnam");
		driver.findElement(By.xpath("//*[@id='Lastname']")).sendKeys("lnam");
		driver.findElement(By.xpath("//*[@name='Mobile']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//*[@name='DateOfBirth']")).sendKeys("22/11/1999");
		driver.findElement(By.xpath("//*[@type='email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//*[@name='HomePhone']")).sendKeys("9876543210");
		driver.findElement(By.xpath("//*[@placeholder='Enter a postcode...']")).click(); // select post code
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@placeholder='Enter a postcode...']")).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER);
		
		
		
	/*	KeyEvent e1;
		Actions a1=new Actions(driver);
		Action a
		Action a=a1.clickAndHold().keyDown(Keys.ARROW_DOWN).build().perform();
		a.*/
	}
	public static void find_patient(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='dropdown-toggle']")).click(); // click menu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@href='/my/#/appointments']")).click(); // click submenu
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@ui-sref='appointment.book.patient']")).click(); // click on right link "select patient
		Thread.sleep(1000);
		/**
		 * Search with invalid data
		 * search with blank field
		 * Search with valid data
		 */
		String id[]= {"Firstname","Lastname","Firstname", "CardNo", "Lastname", };
		String val[]= {"temp","@@&&temp","sagar", "1404568840","patel"};
		for(int i=0;i<id.length;i++)
		{
			driver.findElement(By.xpath("//*[@class='btn btn-link']")).click();
			driver.findElement(By.xpath("//*[@name='"+id[i]+"']")).sendKeys(val[i]);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
			//driver.findElement(By.xpath("//*[@type='submit']")).click();
			Thread.sleep(10000);
			
			if(driver.getPageSource().contains("No patient found please check your criteria."))
			{
				System.out.println(val[i]+" is found.");
			}
			else	
			{
				System.out.println(val[i]+" is not found.");
			}
			
		}
		// select search user by any of under
		//driver.findElement(By.xpath("//*[@class='ng-binding']")).click();
		driver.findElement(By.xpath("//*[@ng-click='vm.selectPatient(itm)']")).click();
		//driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[3]/div[2]/table/tbody/tr/td[1]/a")).click();
		
		
	}
	public static void select_time(WebDriver driver) throws Exception
	{
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/div[3]/ui-view/div/div/section/div/div[2]/div/div/div/div[2]/div[2]/div[2]/ul/li/a")).click();
		//driver.findElement(By.xpath("//*[@ng-click='vm.showpatientappt = false;vm.setPatientRecallDisplay();']")).click();
		driver.findElement(By.xpath("//*[@ui-sref='appointment.book.slotfinder']")).click();
		Thread.sleep(2000);
	/*	String dateval[]= {"15/04/1993","10/06/2018"};
		String daysval[]= {"ui-select-choices-row-1-0","ui-select-choices-row-1-2"};
		String durationval[]= {"ui-select-choices-row-2-4","ui-select-choices-row-2-2"};*/
		String dateval[]= {"10/06/2018"};
		String daysval[]= {"\"ui-select-choices-row-1-2\""};
		String durationval[]= {"ui-select-choices-row-2-2"};
		for(int i=0;i<dateval.length;i++)
		{
			
		driver.findElement(By.xpath("//*[@class='ui-select-match']")).click();
		Thread.sleep(2000);
		
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name='start']")).clear();
		driver.findElement(By.xpath("//*[@name='start']")).sendKeys(dateval[i]);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='days']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='"+daysval[i]+"']")).click();
		Thread.sleep(2000);
		WebElement d1 =driver.findElement(By.xpath("//*[@id='Start']"));
	    d1.clear();d1.sendKeys("11:00");
	    WebElement d2 =driver.findElement(By.xpath("//*[@id='End']"));
	    d2.clear();d2.sendKeys("19:15");
	    Thread.sleep(5000);
		driver.findElement(By.id("daycheck_0")).click();
		driver.findElement(By.id("daycheck_3")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("duration")).click();
		driver.findElement(By.id(durationval[i])).click(); // 45 minuts
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@type='submit']")).click();
		}
		Thread.sleep(3000);
	
		//r.mouseWheel(200);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("11:00 am")).click(); 
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@text='\r\n" + 
		//		"                                            11:00 am\r\n" + 
		//		"                                        ']")).click(); //[@class='btn btn-info btn-sm btn-info-width pushB5 pushR5 ng-binding']
		//driver.findElement(By.xpath("//*[@ng-if='!slotNum.ShowAll && slotNum.length>2']")).click();
		//driver.findElement(By.xpath("//*[text()='more times']")).click();
		//driver.findElement(By.xpath("/html/body/div[3]/ui-view/div/div/section/div/div[2]/div/div/div/div[2]/dt-slot-finder/div/div/div[2]/div[2]/div[2]/div/div/div/div[2]/a")).click();
		Thread.sleep(3000);
		//driver.findElement(By.partialLinkText("02:45 pm")).click();
		
		driver.findElement(By.xpath("//*[@class='btn btn-success pull-right']")).click();
		
	/*	r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);*/
	}
	
}
