package com.jhart.web.analytics.three13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/", "/games/analytics/313"})
public class Three13AnalyticsController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Three13AnalyticsController() {}
	
	@GetMapping("/index")
	public String index(Model model) {
		log.info("Three13AnalyticsController - index");
		return "games/analytics/313/index";
	}
	

}
