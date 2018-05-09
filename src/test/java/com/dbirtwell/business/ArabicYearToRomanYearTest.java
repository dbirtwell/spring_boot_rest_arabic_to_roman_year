/**
 * This is a Unit test showing how to use JUnit 4 @Rule
 */
package com.dbirtwell.business;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArabicYearToRomanYearTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void invalidNegativeYearTest() {
	    thrown.expect(InvalidYearException.class);
	    thrown.expectMessage("The year must be a positive value");
	        
		int year = -123;
		ArabicYearToRomanYear app = new ArabicYearToRomanYear();
		app.toRoman(year);
	}
	
	@Test
	public void invalidYearTooLargeTest() {
	    thrown.expect(InvalidYearException.class);
	    thrown.expectMessage("The largest year allowed is 3999");
	        
		int year = 4000;
		ArabicYearToRomanYear app = new ArabicYearToRomanYear();
		app.toRoman(year);
	}	
	
	@Test
	public void validYearsTest() {
		int year = 3999;
		ArabicYearToRomanYear app = new ArabicYearToRomanYear();
		assertEquals(app.toRoman(year), "MMMCMXCIX");
	}	

}
