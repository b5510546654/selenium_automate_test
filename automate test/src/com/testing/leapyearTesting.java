package com.testing;

import static org.junit.Assert.*;
import java.util.GregorianCalendar;
import org.junit.Test;

public class leapyearTesting {
	
	/**
	 * I choose input -1 because I want to test it can handle negative integer or not.
	 * From Boundary testing.
	 */
	@Test
	public void test1() {		
		String temp = leapYear("-1");
		System.out.println(temp);
		assertEquals("non positive integer", temp);
	}
	
	
	/**
	 * I choose input 0 because it has a high change that programmer use it to calculate.
	 * And forget that 0 shouldn't belong to that case.
	 */
	@Test
	public void test2() {		
		String temp = leapYear("0");
		System.out.println(temp);
		assertEquals("non positive integer", temp);
	}
	
	/**
	 * I choose input 10.2 to represent floating number 
	 * So it can check this program can handle floating value or not.
	 */
	@Test
	public void test3() {		
		String temp = leapYear("10.2");
		System.out.println(temp);
		assertEquals("non positive integer", temp);
	}
	
	/**
	 * Input 400 that is leap year to check that program can calculate correctly.
	 */
	@Test
	public void test4() {		
		String temp = leapYear("400");
		System.out.println(temp);
		assertEquals("true", temp);
	}
	
	/**
	 * Input 2015 that isn't leap year to check that program can calculate correctly.
	 */
	@Test
	public void test5() {		
		String temp = leapYear("2015");
		System.out.println(temp);
		assertEquals("false", temp);
	}

	
	/**
	 * Return non positive integer if input isn't a positive integer
	 * Return true if input is leap year
	 * Return false if input isn't a leap year
	 */
	private String leapYear(String input) {
		int number;
		try {
			number = Integer.parseInt(input);
		} catch (Exception e) {
			return "non positive integer";
		}
		if(number <= 0)
			return "non positive integer";
		GregorianCalendar calendar = new GregorianCalendar();
		return calendar.isLeapYear(number)+"";
	}

}
