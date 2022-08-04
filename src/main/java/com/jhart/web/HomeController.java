package com.jhart.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping({"", "/", "/home"})
	public String home() {
		return "home";
	}

}
