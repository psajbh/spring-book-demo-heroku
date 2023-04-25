package com.jhart.web.analytics.three13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class Three13AnalyticsRestController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Three13AnalyticsRestController() {}
	
	@GetMapping({"threeThirteenAnalyticsTable"})
	public ResponseEntity<Object> getThreeThirteenMetrics(){
		log.info("Three13AnalyticsRestController - getThreeThirteenMetrics()");
		
		
		return null;
		
	}

}
