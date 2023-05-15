package com.jhart.web.analytics.threethirteen;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhart.domain.ThreethirteenMetric;
import com.jhart.dto.ThreethirteenMetricDto;
import com.jhart.service.analytics.threethirteen.ThreethirteenAnalyticsService;

@RestController
@Validated
public class ThreethirteenAnalyticsRestController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private final ThreethirteenAnalyticsService threethirteenAnalyticsService;
	
	public ThreethirteenAnalyticsRestController(
			ThreethirteenAnalyticsService threethirteenAnalyticsService) {
		this.threethirteenAnalyticsService = threethirteenAnalyticsService;
	}
	
	@GetMapping({"threeThirteenAnalyticsTable"})
	public ResponseEntity<Object> getThreeThirteenMetrics(){
		log.info("Three13AnalyticsRestController - getThreeThirteenMetrics()");
		boolean success = false;
		List<ThreethirteenMetricDto> metrics = threethirteenAnalyticsService.getMetrics();
		
		if(null != metrics) {
			success = true;
		}
		
		if (success) {
			return new ResponseEntity<Object>(metrics, HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(null, HttpStatus.I_AM_A_TEAPOT);
		
	}

}
