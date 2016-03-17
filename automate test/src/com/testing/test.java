package com.testing;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import junit.framework.TestCase;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class test extends TestCase {
	WebDriver driver;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test1(){
		Login();
		assertEquals("http://homestead.app/books", driver.getCurrentUrl());
		createBook();

	}
		
	public void Login(){
		driver.get("http://homestead.app");
		driver.findElement(By.name("email")).sendKeys("test@test.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void createBook(){
		driver.findElement(By.linkText("New Book")).click();
		driver.findElement(By.name("name")).sendKeys("New Book");
		driver.findElement(By.name("description")).sendKeys("New Description");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
}
