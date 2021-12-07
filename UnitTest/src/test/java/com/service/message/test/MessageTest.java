package com.service.message.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.service.message.IMessage;
import com.service.message.Message;

/**
 * test class is instantiated for every @Test annotation
 * Hence each Test will have own instantiated messageService.
 * @author kube
 *
 */
public class MessageTest {

	private IMessage messageService;
	
	public MessageTest() {
		System.out.println("Hello CTOR");
		messageService = new Message();
	}
	
	@BeforeAll // executed before all test cases in a test class, should not be private and must be static: void return type
	static void setUp() {
		System.out.println("Hello Before All");
	}
	
	@BeforeEach // executed before each test, should not be private and static: return type void
	void eachSetUp() {
		System.out.println("Hello Before each");
	}
	
	
	@DisplayName("Test Set Message Service")
	@Test // represents a test, should not be private or static, order can be given @TestMethodOrder
	void testSetMessage() {
		assertEquals("Hello !",messageService.getMessage());
		messageService.setMessage("Romil");
	}
	
	@DisplayName("Test Get Message Service")
	@Test // represents a test, should not be private or static, order can be given @TestMethodOrder
	void testGetMessage() {
		assertEquals("Romil",messageService.getMessage());
	}
	
	@DisplayName("Assertion Tests")
	@Test
	void testAssertions() {
		//assertEqual
		assertEquals(20, messageService.getInt());
		
		
		//assertNotEqual
		assertNotEquals(10, messageService.getInt());
		
		//assertTrue
		assertTrue(messageService.getBoolean());
		
		//assertFalse
		assertFalse(messageService.getBoolean() == false);
		
		//assertNotNull
		assertNotNull(messageService.getNull() == null);
		
		//assertNull
		assertNull(messageService.getNull());
		
		//assertSame : same reference
		String location ="India";
		String address = "India";
		assertSame(location, address);
		
		// assertNotSame 
		StringBuffer buffer = new StringBuffer(location);
		
		assertNotSame(buffer.toString(), location);
		
		
	}
	
	@AfterEach // execute after each test case, should not be private or static, void return type
	void tearDown() {
		System.out.println("Hello After Each");
	}
	
	@AfterAll // executed after all test, should not be private and must be static. void return type
	static void clean() {
		System.out.println("Hello After All");
	}
	
	
}
