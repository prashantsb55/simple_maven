package extentReport;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoWebShopAssignment {
@Test
public void addScreenShot() {
	String time = LocalDateTime.now().toString().replace(":", "-");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://demowebshop.tricentis.com/");
	ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_report/DWSA"+time+".html");
	spark.config().setDocumentTitle("My Assignment");
	ExtentReports extReports=new ExtentReports();
	extReports.attachReporter(spark);
	
	ExtentTest test=extReports.createTest("Wellcome page");
	Assert.assertEquals(driver.getTitle(), "Demo Web Shop","Welcome page is not loaded");
	test.log(com.aventstack.extentreports.Status.PASS, "Welcome page is displayed");
	
	driver.findElement(By.partialLinkText("Log in")).click();
	ExtentTest test1=extReports.createTest("Login page");
	Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login","login page is not loaded");
	test.log(com.aventstack.extentreports.Status.PASS, "login page is displayed");
	
	driver.findElement(By.id("Email")).sendKeys("abhis123@gmail.com");
	driver.findElement(By.id("Password")).sendKeys("abhis@1234");
	driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	ExtentTest test2=extReports.createTest("Home page");
	Assert.assertEquals(driver.getTitle(), "Demo Web Shop","Home page is not loaded");
	test.log(com.aventstack.extentreports.Status.PASS, "Home page is displayed");
	
	TakesScreenshot ts=(TakesScreenshot) driver;
	String photo = ts.getScreenshotAs(OutputType.BASE64);
	test2.addScreenCaptureFromBase64String(photo);
	extReports.flush();
	
	
	
}
}
