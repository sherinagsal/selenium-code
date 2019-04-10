package com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest3{
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sherin.raju\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx/");
	  driver.manage().timeouts().implicitlywait(10,TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  WebElement from=driver.findsElement(By.xpath("//div[@id="ctl00_ContentPlaceholder1_RadTreeView1"]/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
	  
	  WebElement to=driver.findsElement(By.id("ctl00_ContentPlaceholder1_priceChecker"]);
	  Actions act1=new Actions(driver);
	  //act1.clickAndHold(from).release(to).perform();
	  act1.dragAndDrop(from, to).perform();
	  
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("//*[@id="ctl00_ContentPlaceholder1_Label1"),"
	  		+ ""
  }
}
