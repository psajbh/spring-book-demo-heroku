
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
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jhart.dto.BuildItemDTO;
import com.jhart.util.BuildModel;

@Controller
public class BuildInfoController {
	Logger log = LoggerFactory.getLogger(this.getClass());

	@SuppressWarnings("unused")
	private BuildModel buildModel;

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
	private final static String NO_BUILD_DATA = "No Build Data available";

	public BuildInfoController(BuildModel buildModel) {
		log.warn("BuildInfoController -");
		this.buildModel = buildModel;
	}

	@GetMapping("buildInfo")
	public String buildInfo(org.springframework.ui.Model model) {
		String buildModel = getBuildModel();
		log.warn("BuildInfoController - buildInfo -" + buildModel);
		
		
		model.addAttribute("data", buildModel);
		log.warn("BuildInfoController - buildInfo -");
		return "about/buildInfo";
	}

	public String getBuildModel() {
		log.warn("BuildInfoController - getBuildModel");
		List<BuildItemDTO> buildItems = new ArrayList<>();
		String json = readGitProperties();

		log.warn("BuildInfoController - getBuildModel: json value: " + json);
		if (json.contentEquals(NO_BUILD_DATA)) {
			log.warn("BuildInfoController - getBuildModel - returning no build data");
			return BuildInfoController.ERROR_MSG;
		}

		if (json.equals(BuildInfoController.ERROR_MSG)) {
			buildItems.add(createBuildItem(BuildInfoController.ERROR_TYPE, BuildInfoController.ERROR_MSG));
		} 
		else {
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
		}

		StringBuilder sb = new StringBuilder();
		sb.append(System.lineSeparator());
		sb.append("Build Information: " + System.lineSeparator());
		ListIterator<BuildItemDTO> buildItemData = buildItems.listIterator();
		while (buildItemData.hasNext()) {
			BuildItemDTO buildItemDto = buildItemData.next();
			sb.append("  " + buildItemDto.getType() + " : " + buildItemDto.getValue() + System.lineSeparator());
		}
		

		return sb.toString();

	}

	private BuildItemDTO createBuildItem(String type, String value) {
		log.warn("BuildInfoController - createBuildItem - type: " + type + " value: " + value);
		BuildItemDTO buildItem = new BuildItemDTO(type, value);
		log.warn("BuildInfoController - createBuildItem - buildItem: " + buildItem.toString());
		return buildItem;
	}

	private String readGitProperties() {
		log.warn("BuildInfoController - readGitProperties - ");
		ClassLoader classLoader = getClass().getClassLoader();
		log.warn("BuildInfoController - readGitProperties - classLoader: " + classLoader);
		InputStream inputStream = classLoader.getResourceAsStream("git.properties");
		log.warn("BuildInfoController - readGitProperties - inputStream: " + inputStream);
		if (inputStream == null) {
			log.warn("BuildInfoController - readGitProperties - inputStream is null -> returning null");
			return NO_BUILD_DATA; // return null; }
		}

		try {
			String input = readFromInputStream(inputStream);
			log.warn("BuildInfoController - readGitProperties - input: " + input);
			return input;
		} catch (IOException e) {
			log.error("BuildInfoController - readGitProperties - input exception: " + e.getMessage());
			e.printStackTrace();
			return "Version information could not be retrieved";
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
