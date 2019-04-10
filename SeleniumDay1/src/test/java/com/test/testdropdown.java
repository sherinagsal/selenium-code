package com.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testdropdown {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sherin.raju\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://hdfcbank.com/");
	  driver.manage().window().maximize();
	  //driver.findElement(By.id("netsafe")).click(); // throws error that element not found
	  JavascriptExecutor js=(JavascriptExecutor) driver;// we use javascript to find the element
	  js.executeScript("document.getElementById('netsafe').click()");
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");// to scroll the page down we can give (0,1000) as pixels too
	  // the first one (0,0) is the horizontal and second 0 is vertical scroll bar 
	  String title=(String)js.executeScript("return document.title");// we can get title using java instead of using get.element
	  // we use hjava scipt here to get the titile
	  System.out.println(title);
	  //js.executeScript("alert('welcome to js')");
	  driver.get("http://demowebshop.tricentis.com/login");
	  js.executeScript("document.getElementById('Email').value='askmail@gmail.com' ");
	  //to enter the email to another website.
	  
  }
}
