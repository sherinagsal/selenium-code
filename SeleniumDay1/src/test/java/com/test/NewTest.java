package com.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sherin.raju\\chromedriver_win32\\chromedriver.exe");
	  WebDriver driver =new ChromeDriver();
	  driver.get("https://www.cleartrip.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(2000);
	  WebElement from = driver.findElement(By.id("FromTag")); // to drag from this
	  //from.sendKeys("h");
	  //from.sendKeys("y");
	  //from.sendKeys("d");
	  Actions act1=new Actions(driver);
	  act1.keyDown(from,Keys.SHIFT).perform();   // for keys to be in caps use keydown for keys to be in small letters 
	  act1.sendKeys("h").perform();
	  Thread.sleep(2000);
	  act1.sendKeys("y").perform();
	  Thread.sleep(2000);
	  act1.sendKeys("d").perform();
	  Thread.sleep(5000);
	  act1.sendKeys(Keys.ENTER).perform();
	  
	  WebElement to = driver.findElement(By.id("ToTag")); // to drop here
	  to.sendKeys("b");
	  to.sendKeys("a");
	  to.sendKeys("n");
	  //Thread.sleep(5000);
	  WebDriverWait wait=new WebDriverWait(driver,10);
	  wait.until(ExpectedConditions.presenceOfNestedElementsLocatedBy(By.id("ui-id-2"),By.className("list")));//to get the count of elements in list
	  WebElement u1=driver.findElement(By.id("ui-id-2"));
	  List<WebElement> list=u1.findElements(By.tagName("li")); // lsit is used e=instead of driver to get list of particular list
	  //Assert.assertEquals(list.size(),10);
	  
	  for(WebElement e:list) // to select the element no matter which position it is present
	  {
		  if(e.getText().contains("HDD"))
		  {
			  e.click();
			  break;
		  }
	  }
	  
	  Assert.assertTrue(to.getAttribute("value").contains("HDD"));
	  
	  
  }
}
