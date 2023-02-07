package com.jhart.web.about;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExternalResourceController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("externalResource")
	public String getExternalResources() {
		log.info("externalResource -");
		return "about/externalResource";
	}

}
