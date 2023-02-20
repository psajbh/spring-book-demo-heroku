
package com.jhart.web.about;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jhart.domain.BuildInfo;
import com.jhart.dto.BuildItemDto;
import com.jhart.service.buildinfo.BuildInfoService;
//import com.jhart.util.BuildModelDto;
=======
import com.jhart.service.buildinfo.BuildInfoService;
import com.jhart.util.BuildModelUtil;
>>>>>>> origin/main

@Controller
public class BuildInfoController {
	Logger log = LoggerFactory.getLogger(this.getClass());

<<<<<<< HEAD
	//@SuppressWarnings("unused")
	//private BuildModelDto buildModel;
	private final static String GIT_BRANCH = "git.branch";
	private final static String BRANCH = "BRANCH: ";
	private final static String GIT_BUILD_HOST = "git.build.host";
	private final static String HOST = "HOST: ";
	private final static String GIT_BUILD_VER = "git.build.version";
	private final static String VERSION = "VERSION: ";
	private final static String GIT_BUILD_TIME = "git.build.time";
	private final static String BUILD_TIME = "BUILD TIME: ";
	private final static String GIT_COMMIT_ID_ABRV = "git.commit.id.abbrev";
	private final static String COMMIT_ID_SHORT = "COMMIT ID (Short): ";
	private final static String COMMIT_ID_LONG = "COMMIT ID (Long): ";
	private final static String GIT_COMMIT_MSG_SHORT = "git.commit.message.short";
	private final static String COMMIT_MSG_SHORT = "COMMIT MSG (Short): ";
	private final static String GIT_COMMIT_TIME = "git.commit.time";
	private final static String COMMIT_TIME = "COMMIT TIME: ";
	private final static String GIT_REMOTE_ORIGIN_URL = "git.remote.origin.url";
	private final static String ORIGIN_URL = "REMOTE ORIGIN URL: ";
	private final static String ERROR_MSG = "Build information could not be retrieved";
	private final static String ERROR_TYPE = "ERROR: "; 
	private final static String NO_BUILD_DATA = "No build data available";
=======
	@SuppressWarnings("unused")
	private BuildModelUtil buildModel;
>>>>>>> origin/main
	
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
