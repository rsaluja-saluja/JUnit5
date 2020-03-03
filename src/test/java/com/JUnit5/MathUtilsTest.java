package com.JUnit5;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// JUnit framework creates Test class object for every test method call
// @TestInstance(TestInstance.Lifecycle.PER_CLASS) // create instance of MathUtilsTest class only once
// @TestInstance(TestInstance.Lifecycle.PER_METHOD) // Create instance of MathUtilsTest class before every test method call
class MathUtilsTest {

	
	public MathUtilsTest() {
		super();
		System.out.println("CTor1");
	}

	MathUtils muObj;
	
	//BeforeAll is called before the first instance of test class is created so it should be static
	// If @TestInstance is defined with PER_CLASS option then static is not reqd. 
	@BeforeAll
	 static void setupBeforeAll() {
		System.out.println("BeforeAll");
	}
	
	@AfterAll
	static void setupAfterAll() {
		System.out.println("AfterAll");
	}
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("BeforeEach");
		muObj = new MathUtils();
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("AfterEach");
		muObj = null;
	}

	@Test
	@DisplayName("Testing Add Method") // Display this name in JUnit results
	void testAdd() {
		System.out.println("Hello Test2");
		assertEquals(8,muObj.add(3, 5));
		//assertEquals(5, muObj.add(1, 3),"Add 1 and 3 fails");
	}
	
	@Test
	//@Disabled("To DO") // JUNIt skip this test case while running
	void testDivide() {
		assertEquals(2, muObj.divide(8, 4));
	}
	
	@Test
	void testDivideException() {
		assertThrows(ArithmeticException.class, () -> muObj.divide(4, 0),"Divide by 0 should throw exception");
	}

	
	//ConditionalExecution
//	@EnableOnOS(OS.LINUX)
//	@EnableOnJre(JRE.JAVA_10)
//	@EnabledIfSystemProperty
//	@EnabledIf
//	@EnabledIfSystemProperty
//	
	
	// Assumption
	//assertTrue
	//assertFalse
	
// assertAll
	
	@Test
	void testMultiple() {
		assertEquals(8, muObj.multiply(2, 4));
		assertEquals(0, muObj.multiply(2, 0));
		assertEquals(5, muObj.multiply(5, 1));
		
		assertAll(
				() ->assertEquals(8, muObj.multiply(2, 4)),
				() ->assertEquals(0, muObj.multiply(2, 0)),
				() -> assertEquals(5, muObj.multiply(5,1))
				);
	}


	
	
}
