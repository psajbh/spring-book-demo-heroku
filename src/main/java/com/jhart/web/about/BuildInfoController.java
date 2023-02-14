
package com.jhart.web.about;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jhart.domain.BuildInfo;
import com.jhart.dto.BuildItemDto;
import com.jhart.service.buildinfo.BuildInfoService;
import com.jhart.util.BuildModelDto;

@Controller
public class BuildInfoController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	private BuildModelDto buildModel;
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
	private final static String GIT_COMMIT_MSG_SHORT = "git.commit.message.short";
	private final static String COMMIT_MSG_SHORT = "COMMIT MSG (Short): ";
	private final static String GIT_COMMIT_TIME = "git.commit.time";
	private final static String COMMIT_TIME = "COMMIT TIME: ";
	private final static String GIT_REMOTE_ORIGIN_URL = "git.remote.origin.url";
	private final static String ORIGIN_URL = "REMOTE ORIGIN URL: ";
	private final static String ERROR_MSG = "Build information could not be retrieved";
	private final static String ERROR_TYPE = "ERROR: "; 
	private final static String NO_BUILD_DATA = "No build data available";
	
	private BuildInfoService buildInfoService;
	
	public BuildInfoController(BuildInfoService buildInfoService) {
	    log.info("BuildInfoController - constructor ");
		this.buildInfoService = buildInfoService;
	}

	@GetMapping("buildInfo")
	public String buildInfo(Model model) {
	    log.info("BuildInfoController - buildInfo()");
		String buildModel = getBuildModel();
		log.debug("BuildInfoController - buildInfo -" + buildModel);
		model.addAttribute("data", buildModel);
		return "about/buildInfo";
	}

	public String getBuildModel() {
		log.info("BuildInfoController - getBuildModel()");
		List<BuildItemDto> buildItems = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String response = null;
		
		String json = readGitProperties();
		log.debug("BuildInfoController - getBuildModel() - json: " + json);
		
		// for test purposes, unmarked below line of code, i.e. json =  NO_BUILD_DATA; 
		json =  NO_BUILD_DATA;  
		// insure the above line is marked before pushing to production
		if (json.contentEquals(NO_BUILD_DATA)) {
			log.info("BuildInfoController - getBuildModel() - no build data available - "
			        + "using buildInfoService as workaround");
			BuildInfo buildInfo = buildInfoService.getLatestBuildInfo();
			
			if (null != buildInfo) {
			    log.info("BuildInfoController - getBuildModel() - buildInfo is NOT null");
			    buildItems.add(createBuildItem(BuildInfoController.BRANCH, buildInfo.getBranch()));
			    buildItems.add(createBuildItem(BuildInfoController.HOST, buildInfo.getHost()));
			    buildItems.add(createBuildItem(BuildInfoController.VERSION, buildInfo.getVersion()));
			    buildItems.add(createBuildItem(BuildInfoController.BUILD_TIME, buildInfo.getBuildTime()));
			    buildItems.add(createBuildItem(BuildInfoController.COMMIT_ID_SHORT, buildInfo.getCommitId()));
			    buildItems.add(createBuildItem(BuildInfoController.COMMIT_MSG_SHORT, buildInfo.getCommitMsg()));
			    buildItems.add(createBuildItem(BuildInfoController.COMMIT_TIME, buildInfo.getCommitTime()));
			    buildItems.add(createBuildItem(BuildInfoController.ORIGIN_URL, buildInfo.getOriginUrl()));
			     
			     sb.append(System.lineSeparator());
			     sb.append("Build Information: " + System.lineSeparator());
			     ListIterator<BuildItemDto> buildItemData = buildItems.listIterator();
			     while (buildItemData.hasNext()) {
			         BuildItemDto buildItemDto = buildItemData.next();
			         sb.append("  " + buildItemDto.getType() + " : " + buildItemDto.getValue() + System.lineSeparator());
			      }
			      response = sb.toString();
			}
			else {
			    log.info("BuildInfoController - getBuildModel() - buildInfo is NULL");
			    buildItems.add(createBuildItem(BuildInfoController.ERROR_TYPE, BuildInfoController.ERROR_MSG));
	            sb.append(System.lineSeparator());
	            sb.append("Build Information: " + System.lineSeparator());
	            ListIterator<BuildItemDto> buildItemData = buildItems.listIterator();
	            while (buildItemData.hasNext()) {
	                BuildItemDto buildItemDto = buildItemData.next();
	                sb.append("  " + buildItemDto.getType() + " : " + buildItemDto.getValue() + System.lineSeparator());
	            }
	            response = sb.toString();
			}
			return response;
		}
		else {
		    log.info("BuildInfoController - getBuildModel() - returning git.properties information");
			Gson gson = new Gson();
			Type stringMap = new TypeToken<Map<String, String>>() {}.getType();
			Map<String, String> map = gson.fromJson(json, stringMap);
			buildItems.add(createBuildItem(BuildInfoController.BRANCH, map.get(BuildInfoController.GIT_BRANCH)));
			buildItems.add(createBuildItem(BuildInfoController.HOST, map.get(BuildInfoController.GIT_BUILD_HOST)));
			buildItems.add(createBuildItem(BuildInfoController.VERSION, map.get(BuildInfoController.GIT_BUILD_VER)));
			buildItems.add(createBuildItem(BuildInfoController.BUILD_TIME, map.get(BuildInfoController.GIT_BUILD_TIME)));
			buildItems.add(createBuildItem(BuildInfoController.COMMIT_ID_SHORT,	map.get(BuildInfoController.GIT_COMMIT_ID_ABRV)));
			buildItems.add(createBuildItem(BuildInfoController.COMMIT_MSG_SHORT, map.get(BuildInfoController.GIT_COMMIT_MSG_SHORT)));
			buildItems.add(createBuildItem(BuildInfoController.COMMIT_TIME, map.get(BuildInfoController.GIT_COMMIT_TIME)));
			buildItems.add(createBuildItem(BuildInfoController.ORIGIN_URL, map.get(BuildInfoController.GIT_REMOTE_ORIGIN_URL)));
			
			sb.append(System.lineSeparator());
			sb.append("Build Information: " + System.lineSeparator());
			ListIterator<BuildItemDto> buildItemData = buildItems.listIterator();
		
			while (buildItemData.hasNext()) {
			    BuildItemDto buildItemDto = buildItemData.next();
			    sb.append("  " + buildItemDto.getType() + " : " + buildItemDto.getValue() + System.lineSeparator());
			}
			response = sb.toString(); 
		}
		
		log.info("BuildInfoController - getBuildModel() - returning: " + response);
		return response;
	}

	private BuildItemDto createBuildItem(String type, String value) {
		log.debug("BuildInfoController - createBuildItem() - type: " + type + " value: " + value);
		BuildItemDto buildItem = new BuildItemDto(type, value);
		log.debug("BuildInfoController - createBuildItem() - buildItem: " + buildItem.toString());
		return buildItem;
	}

	private String readGitProperties() {
		log.debug("BuildInfoController - readGitProperties - ");
		ClassLoader classLoader = getClass().getClassLoader();
		log.debug("BuildInfoController - readGitProperties - classLoader: " + classLoader);
		InputStream inputStream = classLoader.getResourceAsStream("git.properties");
		log.debug("BuildInfoController - readGitProperties - inputStream: " + inputStream);
		if (inputStream == null) {
			log.debug("BuildInfoController - readGitProperties - inputStream is null -> returning null");
			return NO_BUILD_DATA; 
		}

		try {
			String input = readFromInputStream(inputStream);
			log.debug("BuildInfoController - readGitProperties - input: " + input);
			return input;
		} catch (IOException e) {
			log.error("BuildInfoController - readGitProperties - input exception: " + e.getMessage());
			e.printStackTrace();
			return NO_BUILD_DATA;
		}
	}

	private String readFromInputStream(InputStream inputStream) throws IOException {
		log.debug("BuildInfoController - readFromInputStream: ");
		StringBuilder resultStringBuilder = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}

		String result = resultStringBuilder.toString();
		log.debug("BuildInfoController - readFromInputStream - result: " + result);
		return result;

	}

}
