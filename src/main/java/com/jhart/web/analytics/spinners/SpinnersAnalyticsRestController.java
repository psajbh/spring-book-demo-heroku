package com.jhart.web.analytics.spinners;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhart.dto.SpinnersMetricDto;
import com.jhart.service.analytics.spinners.SpinnersAnalyticsService;

@RestController
@Validated
public class SpinnersAnalyticsRestController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final SpinnersAnalyticsService spinnersAnalyticsService;
	
	public SpinnersAnalyticsRestController(SpinnersAnalyticsService spinnersAnalyticsService) {
		this.spinnersAnalyticsService = spinnersAnalyticsService; 
	}
	
	@GetMapping({"spinnersAnalyticsTable"})
	public ResponseEntity<Object> getSpinnersMetrics(){
		log.info("SpinnersAnalyticsRestController - getSpinnersMetrics()");
		boolean success = false;
		List<SpinnersMetricDto> metrics = spinnersAnalyticsService.getMetrics();
		
		if(null != metrics) {
			success = true;
		}
		
		if (success) {
			return new ResponseEntity<Object>(metrics, HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(null, HttpStatus.I_AM_A_TEAPOT);
		
	}


}
