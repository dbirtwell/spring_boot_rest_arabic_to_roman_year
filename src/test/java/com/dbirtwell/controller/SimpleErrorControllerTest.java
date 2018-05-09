package com.dbirtwell.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(SimpleErrorController.class)
public class SimpleErrorControllerTest {
	@Autowired
	private MockMvc mvc;
	
	// TODO: Fix the ERROR to something better
	@Test
	public void testInvalidUrl() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/invalid_url").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andExpect(content().string(
						equalTo("")));
	}
}