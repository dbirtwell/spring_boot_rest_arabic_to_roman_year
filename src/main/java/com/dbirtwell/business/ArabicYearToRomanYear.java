package com.dbirtwell.business;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//import com.dbirtwell.gson.GsonError;
//import com.dbirtwell.gson.GsonResult;
//import com.google.gson.Gson;

/**
 * This class converts Arabic Numeral to Roman Numerals.
 * @author dbirtwell
 *
 */
public class ArabicYearToRomanYear {
	
	private final static int ONE_THOUSAND = 1000;
	private final static int ONE_HUNDRED = 100;
	private final static int TEN = 10;
	
	private static final Map<Integer, String> ROMAN_THOUSANDS;
	static {
	    Map<Integer, String> map = new HashMap<Integer, String>();
	    map.put(1, "M");
	    map.put(2, "MM");
	    map.put(3, "MMM");
	    ROMAN_THOUSANDS = Collections.unmodifiableMap(map);
	}	

	private static final Map<Integer, String> ROMAN_HUNDREDS;
	static {
	    Map<Integer, String> map = new HashMap<Integer, String>();
	    map.put(1, "C");
	    map.put(2, "CC");
	    map.put(3, "CC");
	    map.put(4, "CD");
	    map.put(5, "D");
	    map.put(6, "DC");
	    map.put(7, "DCC");	
	    map.put(8, "DCCC");
	    map.put(9, "CM");	
	    ROMAN_HUNDREDS = Collections.unmodifiableMap(map);
	}

	private static final Map<Integer, String> ROMAN_TENS;
	static {
	    Map<Integer, String> map = new HashMap<Integer, String>();
	    map.put(1, "X");
	    map.put(2, "XX");
	    map.put(3, "XXX");
	    map.put(4, "XL");
	    map.put(5, "L");
	    map.put(6, "LX");
	    map.put(7, "LXX");	
	    map.put(8, "LXXX");
	    map.put(9, "XC");
	    ROMAN_TENS = Collections.unmodifiableMap(map);
	}
	
	public static final Map<Integer, String> ROMAN_ONES;
	static {
	    Map<Integer, String> map = new HashMap<Integer, String>();
	    map.put(1, "I");
	    map.put(2, "II");
	    map.put(3, "III");
	    map.put(4, "IV");
	    map.put(5, "V");
	    map.put(6, "VI");
	    map.put(7, "VII");	
	    map.put(8, "VIII");
	    map.put(9, "IX");
	    ROMAN_ONES = Collections.unmodifiableMap(map);
	}
	
	public String toRoman(int year) throws InvalidYearException{
		//System.out.println("Year to convert: " + year);

		String romanNum = "";	// Holds the resulting Roman Numeral
		int year_part = year;	// Holds the next piece of the year to handle
		
		// Verify we have a valid date
		if (year <= 0) {
			throw new InvalidYearException("The year must be a positive value");
		}		
		else if (year > 3999) {
			throw new InvalidYearException("The largest year allowed is 3999");
		}
	
		// Thousands position
		if(year_part >= ONE_THOUSAND ) {
			int thousands_arabic = year_part / ONE_THOUSAND;
			year_part = year % ONE_THOUSAND;
			
			romanNum += ROMAN_THOUSANDS.get(thousands_arabic);
		}
		
		// Hundreds position
		if(year_part >= ONE_HUNDRED ) {
			int hundreds_arabic = year_part / ONE_HUNDRED;
			year_part = year % ONE_HUNDRED;
			 
			romanNum += ROMAN_HUNDREDS.get(hundreds_arabic);
		}
		
		// Tens position
		if(year_part >= TEN ) {
			int tens_arabic = year_part / TEN;
			year_part = year % TEN;

			romanNum += ROMAN_TENS.get(tens_arabic);
		}
		
		// Ones position
		if(year_part > 0) {
			romanNum += ROMAN_ONES.get(year_part);
			// Note; No year_part hers, as we're done
		}

		return romanNum;
	}
	
//	String toRomanAsJson(int year){
//		
//		GsonResult gsonResult = new GsonResult();
//	  	Gson gson = new Gson();		
//		try {
//			String result = toRoman(year);
//			gsonResult.setResult(result);
//		} catch (InvalidYearException ex) {
//			GsonError error = new GsonError(ex.getMessage(),
//					ex.getMessage());
//			gsonResult.setError(error);
//		}
//		
//    	//System.out.println(gson.toJson(gsonResult));
//    	//System.out.println("There is an error:" + gsonResult.isError());
//    	
//		return gson.toJson(gsonResult);
//	}

}
