package com.dbirtwell.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbirtwell.Application;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArabicToRomanYearControllerIT {
	private static final String LOCAL_HOST = "http://localhost:";
	@LocalServerPort
	private int port;
	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void testHome() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/"), String.class);
		assertThat(response.getBody(), equalTo(ArabicToRomanYearController.HOME_MSG));
	}
	
	@Test
	public void valid_lowerYear1() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/arabic_to_roman_year/1"), String.class);
		assertThat(response.getBody(), equalTo("I"));
	}
	
	@Test
	public void valid_upperYear3999() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/arabic_to_roman_year/3999"), String.class);
		assertThat(response.getBody(), equalTo("MMMCMXCIX"));
	}
	
	@Test
	public void invalid_upperYear4000() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/arabic_to_roman_year/4000"), String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
		assertTrue(response.getBody().contains("The largest year allowed is 3999"));
	}
	
	@Test
	public void invalid_lowerYear0() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/arabic_to_roman_year/0"), String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
		assertTrue(response.getBody().contains("The year must be a positive value"));
	}
	
	@Test
	public void invalid_yearNeg1() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/arabic_to_roman_year/-1"), String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));
		assertTrue(response.getBody().contains("The year must be a positive value"));
	}
	@Test
	public void invalid_yearNonNumeric() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/arabic_to_roman_year/abc"), String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.BAD_REQUEST));		
		assertTrue(response.getBody() == null);
	}	

	private String createURL(String uri) {
		return LOCAL_HOST + port + uri;
	}
}