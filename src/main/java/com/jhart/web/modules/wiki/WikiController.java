package com.jhart.web.modules.wiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WikiController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping({"/wiki/wiki"})
	public String wiki() {
		log.debug("wiki- start");
		return "wiki/wiki";
	}

}
