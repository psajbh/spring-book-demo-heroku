package com.jhart.web.analytics.users;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserAnalyticsController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping({"/analytics/users/index"})
	public String getUsers() {
		log.debug("getUsers - start");
		return "analytics/users/index";
	}


}
