package com.jhart.web.modules.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping({"/users/index"})
	public String getUsers() {
		log.debug("getUsers - start");
		return "users/index";
	}
}
