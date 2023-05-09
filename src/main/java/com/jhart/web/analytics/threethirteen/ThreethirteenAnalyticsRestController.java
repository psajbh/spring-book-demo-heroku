package com.jhart.web.analytics.threethirteen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class ThreethirteenAnalyticsRestController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public ThreethirteenAnalyticsRestController() {}
	
	@GetMapping({"threeThirteenAnalyticsTable"})
	public ResponseEntity<Object> getThreeThirteenMetrics(){
		log.info("Three13AnalyticsRestController - getThreeThirteenMetrics()");
		
		
		return null;
		
	}

}
