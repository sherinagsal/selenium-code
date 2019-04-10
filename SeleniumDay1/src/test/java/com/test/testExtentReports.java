package com.test;

import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class testExtentReports {
	ExtentHtmlReporter htmlreporter;
	ExtentReports reports;
	ExtentTest logger;
	@BeforeTest
	public void beforeTest()
	{
	htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/extent-reports/report1.html");
	reports=new ExtentReports();
	reports.attachReporter(htmlreporter);
	reports.setSystemInfo("host", "LocalHost Training LKM");
	reports.setSystemInfo("username","sherin.raju");
	htmlreporter.config().setTheme(Theme.DARK);
	htmlreporter.config().setReportName("Report for Demo Web Shop");
	}
  @Test
  public void testPass()
  {
	  logger=reports.createTest("test pass");
	  logger.log(Status.PASS,MarkupHelper.createLabel("This test is passed",ExtentColor.GREEN));
  }
  @Test
  public void testFail()
  {
	  logger=reports.createTest("test fail");
	  Assert.assertTrue(false);
  }
  @Test
  public void testSkip()
  {
	  logger=reports.createTest("test skip");
	  throw new SkipException("This test is skipped");
  }
  @AfterMethod
  public void afterMethod(ITestResult result)
  {
	  if(result.getStatus()==ITestResult.FAILURE)
	  {
		  logger.log(Status.FAIL,MarkupHelper.createLabel("This test "+result.getMethod()+"is failed",ExtentColor.RED));
	  }
	  else if(result.getStatus()==ITestResult.SKIP)  
  
  {
	  logger.log(Status.SKIP,MarkupHelper.createLabel("This test"+result.getMethod().getMethodName()+ "is skipped",ExtentColor.ORANGE));
  }
}
@AfterTest
  public void afterTest() {
	reports.flush();//Write the updated information to the html file
  }
}
