
package com.jhart.web.about;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhart.service.buildinfo.BuildInfoService;
import com.jhart.util.BuildModelUtil;

@Controller
public class BuildInfoController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	private BuildModelUtil buildModel;
	private BuildInfoService buildInfoService;
	
	public BuildInfoController(BuildInfoService buildInfoService) {
	    log.info("BuildInfoController - constructor ");
		this.buildInfoService = buildInfoService;
	}

	@GetMapping("buildInfo")
	public String buildInfo(Model model) {
	    log.info("BuildInfoController - buildInfo()");
		String buildModel = buildInfoService.getBuildModel();
		log.debug("BuildInfoController - buildInfo -" + buildModel);
		model.addAttribute("data", buildModel);
		return "about/buildInfo";
	}

}
