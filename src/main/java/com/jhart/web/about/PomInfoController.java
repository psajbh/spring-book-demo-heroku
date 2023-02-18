package com.jhart.web.about;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.jhart.service.pominfo.PomInfoService;

@Controller
public class PomInfoController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private PomInfoService pomInfoService;
	
	public PomInfoController(PomInfoService pomInfoService) {
		log.info("PomInfoController - constructor ");
		this.pomInfoService = pomInfoService;
	}
	
	@GetMapping("pomInfo")
	public String pomInfo(org.springframework.ui.Model model) {
		log.info("PomInfoController - pomInfo()");
		String buildModel = pomInfoService.getBuildModel();
		log.warn("PomInfoController - buildInfo  = " + buildModel);
		model.addAttribute("data", buildModel);
		return "about/pomInfo";
	}
	
}
