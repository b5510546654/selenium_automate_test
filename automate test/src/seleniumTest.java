import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;
import junit.framework.TestResult;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class seleniumTest extends TestCase {

	WebDriver driver;	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		driver = new FirefoxDriver();
	}
	
	@Override
	public TestResult run() {
		return super.run();
	}

	@Test
	public void test4(){
		login();
		enterBook("Test Book");
		editBook();
		deleteBook();
	}
	
	public void login(){
		String email = "test@test.com";
		String password = "123456";
		try{
			driver.get("http://homestead.app/");
			driver.findElement(By.xpath("//ul[2]/li/a")).click();
			driver.findElement(By.linkText("Login")).click();
			driver.findElement(By.name("email")).sendKeys(email);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//div[4]/div/button")).click();
		}
		catch(Exception e){
			System.out.println("error in Login");
		}		
		assertEquals("http://homestead.app/books",driver.getCurrentUrl());
	}
	
	public void enterBook(String book){
		try{
			driver.findElement(By.linkText(book)).click();	
		}
		catch(Exception e){
			System.out.println("Error in enter Book");
		}
	}

	public void editBook(){
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
	
	public void createContent(){
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
	
	public void deleteBook(){
		driver.findElement(By.xpath("//iknput[@value='Delete This Book']")).click();
	}

	
	
}
