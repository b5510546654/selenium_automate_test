package com.testing;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import junit.framework.*;

public class googleSearchTesting extends TestCase {

	static WebDriver driver;	

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
//		for(int i = 0; i<2 ;i++){
//			if(i == 0)
		
//				driver = new FirefoxDriver();
				
//			else
				driver = new RemoteWebDriver(new URL("http://localhost:9515"), DesiredCapabilities.chrome());
				
			driver.get("http://homestead.app/");
			
			Thread.sleep(2000);
			Login();
			
			
			
			Thread.sleep(2000);
			CreateBook();
			Thread.sleep(2000);
			enterBook();
			Thread.sleep(2000);
			editBook();
			Thread.sleep(2000);
			createContent();
			Thread.sleep(2000);
			deleteBook();
			Thread.sleep(2000);
			driver.close();
//		}
	}

	public static void Login(){
		String email = "test@test.com";
		String password = "123456";
		try{
			
			driver.findElement(By.linkText("Hello, guest!")).click();
			
			driver.findElement(By.linkText("Login")).click();
			
			driver.findElement(By.name("email")).sendKeys(email);
			
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//div[4]/div/button")).click();
				
	        assertEquals("Hello, user!", 
	        		driver.findElement(By.linkText("Hello, user!")).getText());
	        
	        
		}
		catch(Exception e){
			System.out.println("error in Login");
		}
	}

	public static void CreateBook() throws InterruptedException{
		String book = "Test Book";
		String desc = "Test Description";
		try{
			driver.findElement(By.xpath("//a/div")).click();
			driver.findElement(By.xpath("//a[@href='http://homestead.app/books/create']")).click();
			driver.findElement(By.name("name")).sendKeys(book);
			driver.findElement(By.name("description")).sendKeys(desc);
			driver.findElement(By.xpath("//div[4]/div/button")).click();
		}
		catch(Exception e){
			System.out.println("error in create book");
		}
	}

	public static void enterBook(){
		try{
			String book = "Test Book";
			driver.findElement(By.linkText(book)).click();	
		}
		catch(Exception e){
			System.out.println("Error in enter Book");
		}
	}

	public static void editBook(){
		try{
			String book = "Test Book after edit";
			driver.findElement(By.xpath("//input[@value='Edit This Book']")).click();
			driver.findElement(By.id("name")).sendKeys(book);	
			driver.findElement(By.xpath("//input[@value='Edit']")).click();
		}		
		catch(Exception e){
			System.out.println("Error in edit Book");
		}
				
	}
	
	public static void createContent(){
		String[] name = {"First Chapter","Second Chapter"};
		String[] content = {"... / ... / ... / ... ","........@@@@@@@@@@@@.........."};
		for(int i = 0;i<2;i++){
			driver.findElement(By.xpath("//input[@value='New Chapter']")).click();
			driver.findElement(By.id("name")).sendKeys(name[i]);
			driver.findElement(By.id("content")).sendKeys(content[i]);
			driver.findElement(By.id("chapter")).sendKeys(""+(i+1));				
			driver.findElement(By.xpath("//input[@value='Add Chapter']")).click();
		}
	}
	
	public static void deleteBook(){
		driver.findElement(By.xpath("//input[@value='Delete This Book']")).click();
	}

}
