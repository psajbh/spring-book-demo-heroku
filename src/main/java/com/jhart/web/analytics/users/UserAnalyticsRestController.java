package com.jhart.web.analytics.users;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhart.dto.UserBackBean;
import com.jhart.orchestration.user.UserConductor;

@RestController
@Validated
public class UserAnalyticsRestController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private UserConductor conductor;
	
	public UserAnalyticsRestController(UserConductor conductor) {
		this.conductor = conductor;
	}
	
	@GetMapping({"userDataTableAnalytics"})
	public ResponseEntity<Object> getAllUsers(){
		log.debug("getAllUsers- start");
		boolean success = false;
		List<UserBackBean> userBackBeans = conductor.getAllUserBackBeans();
		if (null != userBackBeans) {
			success = true;
		}
		
		log.debug("getAllUsers- success: " + success);
		
		if (success) {
			return new ResponseEntity<Object>(userBackBeans,HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(null,HttpStatus.I_AM_A_TEAPOT);
	}

}
