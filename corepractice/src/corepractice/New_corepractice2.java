package corepractice;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class New_corepractice2 {
  private WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");
    driver = new FirefoxDriver();
//    System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
  //  driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
	    driver.get("https://test.corepractice.is/#/");
	    driver.findElement(By.id("Password")).clear();
	    driver.findElement(By.id("Password")).sendKeys("ShahElsner2018");
	    driver.findElement(By.id("Username")).clear();
	    driver.findElement(By.id("Username")).sendKeys("harshal");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@id='navbar']/ul/li/a/span")).click();
	    driver.findElement(By.xpath("(//a[contains(text(),'Appointment Book')])[2]")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	    driver.findElement(By.linkText("Default Practice")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[@data-time='09:00:00']")).click();
	    driver.findElement(By.linkText("Select Patient")).click();
	    driver.findElement(By.name("Firstname")).clear();
	    driver.findElement(By.name("Firstname")).sendKeys("harshal");
	    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
	    driver.findElement(By.linkText("Mr Harshal Shah")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
   // driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
