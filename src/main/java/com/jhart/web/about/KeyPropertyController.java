package com.jhart.web.about;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class KeyPropertyController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	public KeyPropertyController() {}
	
	public String getKeyProperties() {
		log.info("KeyPropertyController - getKeyProperties()");
		String runtimeVersion = System.getProperty("java.runtime.version");
		
		
		
		return null;
	}
	
	

}
