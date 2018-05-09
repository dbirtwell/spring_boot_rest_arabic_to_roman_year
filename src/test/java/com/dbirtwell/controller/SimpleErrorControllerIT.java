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
public class SimpleErrorControllerIT {
	private static final String LOCAL_HOST = "http://localhost:";
	@LocalServerPort
	private int port;
	private TestRestTemplate template = new TestRestTemplate();

	@Test
	public void testInvalidUrl() throws Exception {
		ResponseEntity<String> response = template.getForEntity(createURL("/invalid_url"), String.class);
		assertThat(response.getBody(), equalTo(
				"ERROR *** TODO: Add Better Error handling"));
	}
	
	private String createURL(String uri) {
		return LOCAL_HOST + port + uri;
	}
}