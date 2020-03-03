package com.JUnit5;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

// JUnit framework creates Test class object for every test method call
// @TestInstance(TestInstance.Lifecycle.PER_CLASS) // create instance of MathUtilsTest class only once
// @TestInstance(TestInstance.Lifecycle.PER_METHOD) // Create instance of MathUtilsTest class before every test method call
@DisplayName("MathUtil test to test Nested Class, lambda in failure message, RepeatedTest")
class MathUtilsTest1 {

	public MathUtilsTest1() {
		super();
		System.out.println("CTor");
	}

	MathUtils muObj;

	// BeforeAll is called before the first instance of test class is created so it
	// should be static
	// If @TestInstance is defined with PER_CLASS option then static is not reqd.

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

	//AddTest group of test would be success when all test cases are passed otherwise it would fail
	@Nested
	@DisplayName("Testing add method")
	class AddTest {

		@Test
		@DisplayName("Testing Add Method with positive parameters") // Display this name in JUnit results
		void testAddPositive() {
			assertEquals(8, muObj.add(3, 5),"should return correct sum ");

		}

		@Test
		@DisplayName("Testing Add Method with negative parameters") // Display this name in JUnit results
		void testAddNegative() {
			assertEquals(-5, muObj.add(-3, -2),"should return correct sum");
			

		}
		@Test
		void testAddPositiveNegative() {
			int expected = 0;
			int actual = muObj.add(-3, 3);
			assertEquals(expected, actual,()->failureMessage(expected, actual));
		}
		
		String failureMessage(int expected, int actual) {
			return "Should return " + expected +" but returning " + actual;
		}
	}

	//@Test
	@RepeatedTest(5)
	void testDivide() {
		//void testDivide(RepetitionInfo repInfo) {
		//if(repInfo.getCurrentRepetition() != 2) //RepetitionInfo have info about repetition
		assertEquals(2, muObj.divide(8, 4));
		
		
	}

}
