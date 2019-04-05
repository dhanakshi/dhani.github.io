package com.cognizant.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cognizant.controller.AdminController;
import com.cognizant.service.UnitTestingService;

public class JUnitTesting
{
	private AdminController admincontroller=null;
	
	@Before
	public void setUp() throws Exception
	{
		admincontroller=new AdminController();
	}
	
	@After
	public void tearDown() throws Exception
	{
		admincontroller=null;
	}
	
	@Test
	public void testFirstName_positive()
	{
		try {
			String actual = admincontroller.firstName;
			String expected = "Dhanakshi";
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail("not a username");
		}
	}
	
	@Test
	public void testFirstName_negative()
	{
		try {
			String actual = admincontroller.firstName;
			String expected = "Dhanakshi";
			assertTrue(actual.length()>expected.length());
		} catch (Exception e) {
			assertTrue(true);
			String expected="First Name is too long";
			assertEquals(expected,e.getMessage());
		}
	}
	
	@Test
	public void testLastName_positive()
	{
		try {
			String actual = admincontroller.lastName;
			String expected = "Jain";
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail("not a valid username");
		}
	}
	
	@Test
	public void testLastName_negative()
	{
		try {
			String actual = "DhanakshiJain";
			String expected = "Jain";
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
			String expected="Last Name too long";
			assertEquals(expected,e.getMessage());
		}
	}
	
	@Test
	public void testPassword_positive()
	{
		try {
			String actual = admincontroller.password;
			String expected = "Dhani";
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail("Incorrect password");
		}
	}
	
	@Test
	public void testPassword_negative()
	{
		try {
			String actual = admincontroller.password;
			String expected = "Dhani";
			assertTrue(false);
		} catch (Exception e) {
			assertTrue(true);
			String expected="Password cannot be empty";
			assertEquals(expected,e.getMessage());
		}
	}
	
	@Test
	public void testAge_positive()
	{
		try {
			int actual = admincontroller.age;
			int expected = 22;
			assertEquals(expected, actual);
		} catch (Exception e) {
			fail("Incorrect age");
		}
	}
	
}
