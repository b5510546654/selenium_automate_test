package com.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RorPapTestOnChrome {
	
	private WebDriver driver;
	
	private int counter;
		
	public RorPapTestOnChrome(){
		counter = 0;
		try {
			init();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Some Error Has Occured in RorPapTestOnChrome.java");
			e.printStackTrace();
		}
	}
	
	private void createDriver(){
		// Setup google chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\library\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8080/#!/");
		
		counter++;
	}
	
	private void destroyDriver(){
		driver.close();
	}
	

	private void init() throws InterruptedException {
		/*createDriver(); testSignUpForPasswordMisMatching(); destroyDriver();
		createDriver(); testSignUpWithIncorrectDateOfBirth(); destroyDriver();
		createDriver(); testSignUpWithFutureDateOfBirth(); destroyDriver();
		createDriver(); testSignUpWithOutAcceptingPolicy(); destroyDriver();
		createDriver(); testSignUpWithInvalidEmailAddress(); destroyDriver();
		createDriver(); testSignUpWithCorrectInformation(); destroyDriver();
		createDriver(); testLogInWithCreatedAccount(); destroyDriver();
		createDriver(); testLogInWithNotCreatedAccount(); destroyDriver();
		createDriver(); testLogInAndRememberMe(); destroyDriver();
		createDriver(); testLogInForgotPassword(); destroyDriver();
		createDriver(); testLogInUsingNotCreatedAccount(); destroyDriver();
		createDriver(); testLogInUsingCreatedAccountButWrongPassword(); destroyDriver();
		createDriver(); testEditUserProfileWithoutFillInPassword(); destroyDriver();*/
		createDriver(); testEditUserProfileWithPasswordFilledIn(); destroyDriver();
	}
	
	/**
	 * Test for Edit user profile module.
	 * 		Test for editing user profile with the password filled in.
	 * @throws InterruptedException 
	 */
	private void testEditUserProfileWithPasswordFilledIn() throws InterruptedException{
		testLogInWithCreatedAccount();
		
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("profileDropDown")).click();
		driver.findElement(By.id("lastName")).clear();
		driver.findElement(By.id("lastName")).sendKeys("NewLastName");
		driver.findElement(By.id("password1")).sendKeys("123456");
		driver.findElement(By.id("updateProfileBtn")).click();		
		System.out.println("I'm done with \'Test Edit user profile with the password filled in.\'");
		
		Thread.sleep(50000);
	}
	
	/**
	 * Test for Edit user profile module.
	 * 		Test for editing user profile without filling in the password.
	 * @throws InterruptedException 
	 */
	private void testEditUserProfileWithoutFillInPassword() throws InterruptedException{
		testLogInWithCreatedAccount();
		
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("profileDropDown")).click();
		driver.findElement(By.id("lastName")).sendKeys("NewLastName");
		driver.findElement(By.id("updateProfileBtn")).click();		
		System.out.println("I'm done with \'Test Edit user profile without filling in the password.\'");
		
		Thread.sleep(50000);		
	}
	
	/**
	 * Test for Log in module.
	 * 		Test for logging in using created account but entering wrong password.
	 * @throws InterruptedException 
	 */
	private void testLogInUsingCreatedAccountButWrongPassword() throws InterruptedException{
		testSignUpWithCorrectInformation();
		
		driver.findElement(By.linkText("Log In")).click();				
		driver.findElement(By.id("emailAddressLogIn")).sendKeys("TesterName".concat(counter+"").concat("@tester.com"));
		driver.findElement(By.id("password")).sendKeys("this is a wrong password");
		driver.findElement(By.id("logInBtn")).click();
		
		System.out.println("I'm done with \'Test Log In with created account but wrong password.\'");
		
		Thread.sleep(10000);
	}
	
	/**
	 * Test for Log in module.
	 * 		Test for logging in using unknown account which should redirect to sign up page.
	 * @throws InterruptedException 
	 */
	private void testLogInUsingNotCreatedAccount() throws InterruptedException{
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("emailAddressLogIn")).sendKeys("TesterName".concat("TesterEiei").concat("@tester.com"));
		driver.findElement(By.id("password")).sendKeys("123456");
		driver.findElement(By.id("logInBtn")).click();
		
		Thread.sleep(10000);
		
		System.out.println("I'm done with \'Test Log In using unknown account.\'");
	}
	
	/**
	 * Test for Log in module.
	 * 		Test for user forgot password.
	 * @throws InterruptedException 
	 */
	private void testLogInForgotPassword() throws InterruptedException{
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("emailAddressLogIn")).sendKeys("TesterName".concat(counter+"").concat("@tester.com"));
		driver.findElement(By.id("forgetPassword")).click();
		
		Thread.sleep(10000);
		
		System.out.println("I'm done with \'Test Log In and user forgot password.\'");
	}
	
	/**
	 * Test for Log in module.
	 * 		Test for logging in with created account and select remember me.
	 * @throws InterruptedException 
	 */
	private void testLogInAndRememberMe() throws InterruptedException{
		testSignUpWithCorrectInformation();
		
		driver.findElement(By.linkText("Log In")).click();				
		driver.findElement(By.id("emailAddressLogIn")).sendKeys("TesterName".concat(counter+"").concat("@tester.com"));
		driver.findElement(By.id("password")).sendKeys("123456");		
		driver.findElement(By.id("rememberMeLabel")).click();
		driver.findElement(By.id("logInBtn")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Profile")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Log Out")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("confirmLogOut")).click();
		
		driver.findElement(By.linkText("Log In")).click();
		
		System.out.println("I'm done with \'Test Log In with created account and remember me.\'");
		
		Thread.sleep(10000);
	}
	
	/**
	 * Test for Log in module.
	 * 		Test for logging in with not created account.
	 * @throws InterruptedException 
	 */
	private void testLogInWithNotCreatedAccount() throws InterruptedException{
		driver.findElement(By.linkText("Log In")).click();
		
		driver.findElement(By.id("emailAddressLogIn")).sendKeys("unknownaccount1@tester.com");
		driver.findElement(By.id("password")).sendKeys("123456");
		
		driver.findElement(By.id("logInBtn")).click();
		
		System.out.println("I'm done with \'Test Log In with not created account.\'");
		
		Thread.sleep(3000);		
	}
	
	/**
	 * Test for Log in module.
	 * 		Test for logging in with created account.
	 * @throws InterruptedException 
	 */
	private void testLogInWithCreatedAccount() throws InterruptedException{
		testSignUpWithCorrectInformation();
		
		driver.findElement(By.linkText("Log In")).click();
				
		driver.findElement(By.id("emailAddressLogIn")).sendKeys("TesterName".concat(counter+"").concat("@tester.com"));
		driver.findElement(By.id("password")).sendKeys("123456");
		
		driver.findElement(By.id("logInBtn")).click();
		
		System.out.println("I'm done with \'Test Log In with created account.\'");
		
		Thread.sleep(10000);
	}
	
	/**
	 * Test for Create User Account module.
	 * 		Test for signing up with correct information.
	 * @throws InterruptedException 
	 */
	private void testSignUpWithCorrectInformation() throws InterruptedException{
		String firstName = "TesterName".concat(counter+"");
		String lastName = "TesterLastName".concat(counter+"");
		String emailAddress = firstName.concat("@tester.com");
		String password1 = "123456";
		String password2 = "123456";
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("emailAddress")).sendKeys(emailAddress);
		driver.findElement(By.id("password1")).sendKeys(password1);
		driver.findElement(By.id("password2")).sendKeys(password2);
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		// Set Date to be 10
		for(int i = 0; i < 10; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}		
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Month to be December
		for(int i = 0; i < 12; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Year to be 2000
		for(int i = 0; i < 17; i++){
			dateOfBirth.sendKeys(Keys.ARROW_DOWN);
		}
		
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up with correct information.\'");
	}
	
	/**
	 * Test for Create User Account module.
	 * 		Test for signing up with invalid email address
	 * @throws InterruptedException 
	 */
	private void testSignUpWithInvalidEmailAddress() throws InterruptedException{
		String firstName = "น้องน้อตนะจ๊ะ";
		String lastName = "นามสกุลของน้อต";
		String emailAddress = "น้องน้อตอีเมลล์จ้า@hotmail.com";
		String password1 = "123456";
		String password2 = "123456";
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("emailAddress")).sendKeys(emailAddress);
		driver.findElement(By.id("password1")).sendKeys(password1);
		driver.findElement(By.id("password2")).sendKeys(password2);
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		// Set Date to be 10
		for(int i = 0; i < 10; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}		
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Month to be December
		for(int i = 0; i < 12; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Year to be 2000
		for(int i = 0; i < 17; i++){
			dateOfBirth.sendKeys(Keys.ARROW_DOWN);
		}
		
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up with invalid email address.\'");
	}
	
	/**
	 * Test for Create User Account module.
	 * 		Test for signing up without accepting policy.
	 * @throws InterruptedException 
	 */
	private void testSignUpWithOutAcceptingPolicy() throws InterruptedException{
		String firstName = "TesterName".concat(counter+"");
		String lastName = "TesterLastName".concat(counter+"");
		String emailAddress = firstName.concat("@tester.com");
		String password1 = "123456";
		String password2 = "123456";
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("emailAddress")).sendKeys(emailAddress);
		driver.findElement(By.id("password1")).sendKeys(password1);
		driver.findElement(By.id("password2")).sendKeys(password2);
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		// Set Date to be 10
		for(int i = 0; i < 10; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}		
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Month to be December
		for(int i = 0; i < 12; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Year to be 2000
		for(int i = 0; i < 17; i++){
			dateOfBirth.sendKeys(Keys.ARROW_DOWN);
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up without accepting policy.\'");
	}
	
	/**
	 * Test for Create User Account module.
	 * 		Test for signing up when the date of birth is in the future.
	 * @throws InterruptedException 
	 */
	private void testSignUpWithFutureDateOfBirth() throws InterruptedException{
		String firstName = "TesterName".concat(counter+"");
		String lastName = "TesterLastName".concat(counter+"");
		String emailAddress = firstName.concat("@tester.com");
		String password1 = "123456";
		String password2 = "123456";
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("emailAddress")).sendKeys(emailAddress);
		driver.findElement(By.id("password1")).sendKeys(password1);
		driver.findElement(By.id("password2")).sendKeys(password2);
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		// Set Date to be 30
		for(int i = 0; i < 30; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}		
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Month to be April
		for(int i = 0; i < 4; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Year to be 2030
		for(int i = 0; i < 15; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}
				
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up When Date of Birth is the future date.\'");
	}
	
	/**
	 * Test for Create User Account module.
	 * 		Test for signing up when the date of birth is invalid.
	 * @throws InterruptedException 
	 */
	private void testSignUpWithIncorrectDateOfBirth() throws InterruptedException {
		String firstName = "TesterName".concat(counter+"");
		String lastName = "TesterLastName".concat(counter+"");
		String emailAddress = firstName.concat("@tester.com");
		String password1 = "123456";
		String password2 = "123456";
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("emailAddress")).sendKeys(emailAddress);
		driver.findElement(By.id("password1")).sendKeys(password1);
		driver.findElement(By.id("password2")).sendKeys(password2);
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		// Set Date to be 31
		for(int i = 0; i < 31; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}		
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Month to be February
		for(int i = 0; i < 2; i++){
			dateOfBirth.sendKeys(Keys.ARROW_UP);
		}
		dateOfBirth.sendKeys(Keys.TAB);
		// Set Year to be 2016
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up When Date of Birth is invalid.\'");		
	}


	/**
	 * Test for Create User Account module.
	 * 		Test for signing up when password mismatch.
	 * @throws InterruptedException 
	 */
	private void testSignUpForPasswordMisMatching() throws InterruptedException{
		String firstName = "TesterName".concat(counter+"");
		String lastName = "TesterLastName".concat(counter+"");
		String emailAddress = firstName.concat("@tester.com");
		String password1 = "123456";
		String password2 = "654321";
		
		driver.findElement(By.linkText("Sign Up")).click();
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		driver.findElement(By.id("lastName")).sendKeys(lastName);
		driver.findElement(By.id("emailAddress")).sendKeys(emailAddress);
		driver.findElement(By.id("password1")).sendKeys(password1);
		driver.findElement(By.id("password2")).sendKeys(password2);
		
		WebElement dateOfBirth= driver.findElement(By.id("dateOfBirth"));
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		dateOfBirth.sendKeys(Keys.TAB);
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		dateOfBirth.sendKeys(Keys.TAB);
		dateOfBirth.sendKeys(Keys.ARROW_UP);
		
		if(!driver.findElement(By.id("acceptPolicyLabel")).isSelected()){
			driver.findElement(By.id("acceptPolicyLabel")).click();
		}
		
		driver.findElement(By.id("signUpBtn")).click();
				
		Thread.sleep(3000);
		
		System.out.println("I'm done with \'Test Sign Up For Password Mismatching\'");
	}

}
