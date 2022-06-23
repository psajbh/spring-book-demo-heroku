package com.jhart.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TimeZone;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "Hello World! Current local time is: " + getTime(); 
	}
	
	private String getTime() {
		String date = LocalDate.now().toString();
		String time = LocalTime.now().toString();
		System.out.println("Current local date (time): " + date + " (" + time + ")");
		String zoneId = getZoneId();
		return date + " (" + time + ") " + "TZ: " + zoneId;
	}
	
	private String getZoneId() {
		TimeZone tz = TimeZone.getDefault();
		return tz.getID();
	}

}
