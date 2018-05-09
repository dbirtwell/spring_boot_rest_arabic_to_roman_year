package com.dbirtwell.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(ArabicToRomanYearController.class)
public class ArabicToRomanYearControllerTest {
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	public void testHome() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(
						equalTo(ArabicToRomanYearController.HOME_MSG)));
	}

	@Test
	public void valid_year11() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/arabic_to_roman_year/11").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("XI")));
	}
	
	@Test
	public void valid_upperYear3999() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/arabic_to_roman_year/3999").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("MMMCMXCIX")));
	}
	
	@Test
	public void valid_lowerYear1() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/arabic_to_roman_year/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(equalTo("I")));
	}
	
	@Test
	public void invalid_year0() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/arabic_to_roman_year/0").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andReturn();
		String response = result.getResponse().getContentAsString();
		assertTrue(response.contains("The year must be a positive value"));
	}
	
	@Test
	public void invalid_year4000() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/arabic_to_roman_year/4000").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest()).andReturn();
		String response = result.getResponse().getContentAsString();
		assertTrue(response.contains("The largest year allowed is 3999"));
	}	

	// TODO: Fix the ERRORS for an invalid number to something better	
	@Test
	public void invalid_year_abc() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/arabic_to_roman_year/abc").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().is4xxClientError()).andReturn();
		String response = result.getResponse().getContentAsString();
		assertTrue(response.contains(""));
	}	

}