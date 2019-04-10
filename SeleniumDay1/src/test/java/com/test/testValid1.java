package com.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class testValid1 {
	@BeforeMethod
	public void beforeTest()
	{
		driver=new hromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demowebshop.tricentis.com/login");
	}
  @AfterTest
  public void afterTest()
  {
	  driver.close();
  }
  @Test(dataProvider='dp1')
  public void f(String username,String password) {
	  driver.findElement(By.id("Email")).sendKeys(username);
	  driver.findElement(By.id("Password")).sendKeys(password);
	  driver.findElement(By.xpath("//input@value='Log in']")).sendKeys(username);
	  driver.findElement(By.linkText("Log out")).click();
	  driver.findElement(By.linkText("Log in")).click();
	  
  }
}
