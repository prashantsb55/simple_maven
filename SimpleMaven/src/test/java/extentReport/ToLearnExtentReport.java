package extentReport;

import java.time.LocalDateTime;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
@Test
public void report() {
	String time = LocalDateTime.now().toString().replace(":", "-");
		//step1 create an instance of ExtentSparkReport
		ExtentSparkReporter spark=new ExtentSparkReporter("./HTML_reports/extentReport.html");
		
		//step2 create an instance of extentReports
		ExtentReports extReport=new ExtentReports();
		
		//step3 attach an instance of extentSparkReporter to ExtentReports
		extReport.attachReporter(spark);
		
		
		//step4 create an instance of ExtentTest
		ExtentTest test=extReport.createTest("report");
		
		//step5 call log() to provide status and log message
		test.log(Status.PASS, "log message added into report");
		
		//step6 call flush() to write messages into destination
		extReport.flush();
	}


	
}

