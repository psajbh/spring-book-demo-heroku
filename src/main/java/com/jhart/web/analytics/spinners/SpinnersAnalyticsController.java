package com.jhart.web.analytics.spinners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpinnersAnalyticsController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping({"/analytics/games/spinners/index"})
	public String index(Model model) {
		log.info("SpinnersAnalyticsController - index");
		return "analytics/games/spinners/index";
	}
	

}
