package com.technicaltest.CurrentTime.controller;

import org.joda.time.MutableDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/time")
public class TimeController {
	@RequestMapping(method = RequestMethod.GET, path = "/current")
	public @ResponseBody String sayCurrentTime() {
		MutableDateTime now = new MutableDateTime();
		
		/*String str = now.toString();
		String str1 = str.substring(0, 10);
		return str1;*/
		
		return now.toString();
	}

}