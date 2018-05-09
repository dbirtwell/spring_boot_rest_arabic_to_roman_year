package com.dbirtwell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbirtwell.business.ArabicYearToRomanYear;

@RestController
public class ArabicToRomanYearController {
	
	protected static final String HOME_MSG = 
			"Try using the path /arabic_to_roman_year/year_to_convert, "
					+ "where year_to_convert is a positive Arabic numeral less than 4000.";
	
	@GetMapping(path = "/")
	public String home() {
		return HOME_MSG;
	}
	
	@GetMapping(path = "arabic_to_roman_year/{year}")
	public String convertArabicYearToRomanYear(@PathVariable int year) {
		ArabicYearToRomanYear app 
			= new ArabicYearToRomanYear();
		return app.toRoman(year);
	}
}
