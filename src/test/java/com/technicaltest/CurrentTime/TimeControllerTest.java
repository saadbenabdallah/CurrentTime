package com.technicaltest.CurrentTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TimeControllerTest {
	@Autowired
	private MockMvc mockMvc;

	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@Test
	public void currentTimeShouldReturnTime() throws Exception {

		MvcResult result = this.mockMvc.perform(get("/time/current")).andDo(print()).andExpect(status().isOk())
				.andReturn();

		String content = result.getResponse().getContentAsString();

		DateTime contentDateTime = DateTime.parse(content);
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss");
		Assert.assertEquals(SIMPLE_DATE_FORMAT.format(new Date()), dateTimeFormatter.print(contentDateTime));

		/*
		 * this.mockMvc.perform(get("/time/current")).andDo(print()).andExpect(status().
		 * isOk()) .andExpect(jsonPath("$").value("2018-01-16T00:00:00.000-05:00"));
		 */
	}

}
