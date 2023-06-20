package com.jhart.web.analytics.threethirteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//@RequestMapping({"", "/", "/analytics/games/threethirteen"})
public class ThreethirteenAnalyticsController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	//public ThreethirteenAnalyticsController() {}
	
	@GetMapping({"/analytics/games/threethirteen/index"})
	public String index(Model model) {
		log.info("Three13AnalyticsController - index");
		return "analytics/games/threethirteen/index";
	}
	

}
