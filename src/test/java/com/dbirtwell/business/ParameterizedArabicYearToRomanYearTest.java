/**
 * This is a Unit test showing how to use JUnit 4 Parameterized Tests
 */
package com.dbirtwell.business;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class ParameterizedArabicYearToRomanYearTest {

	private int inputYear;
	private String expectedResult;

	// Each parameter should be placed as an argument here
	// Every time runner triggers, it will pass the arguments
	// from parameters we defined in the arabicToRomanNumbers() method

	public ParameterizedArabicYearToRomanYearTest(int inputYear,
			String expectedResult) {
		this.inputYear = inputYear;
		this.expectedResult = expectedResult;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> arabicToRomanNumbers() {
		
		// TODO: Add more tests here, this is just to show how to paramterize
		// test values
		return Arrays.asList(new Object[][] {
				{ 1, "I" },
				{ 1000, "M" },
				{ 1888, "MDCCCLXXXVIII" },
				{ 1961, "MCMLXI" },
				{ 3999, "MMMCMXCIX" }
		});
	}

	// This test will run 5 times since we have 5 parameters defined
	@Test
	public void testArabicYearToRomanYear() {
		System.out.println("Parameterized Number is : " + inputYear);
		ArabicYearToRomanYear app = new ArabicYearToRomanYear();
		assertEquals(expectedResult, 
				app.toRoman(inputYear));
	}	

}
