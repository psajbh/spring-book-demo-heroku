package com.jhart.service.buildinfo;

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
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jhart.domain.BuildInfo;
import com.jhart.dto.BuildItemDto;
import com.jhart.repo.buildinfo.BuildInfoRepository;

@Service
public class BuildInfoServiceImpl implements BuildInfoService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	private final BuildInfoRepository buildInfoRepository;
	
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
	
	public BuildInfoServiceImpl(BuildInfoRepository buildInfoRepository) {
		this.buildInfoRepository = buildInfoRepository;
	}
	
	@Override
	public BuildInfo getLatestBuildInfo() {
		
		Long mostCurrentId = 0L;
		BuildInfo mostCurrentBuildInfo = null;
		
		List<BuildInfo>  list  = buildInfoRepository.findAll();
		System.out.println("list: " + list);
		
		for (BuildInfo buildInfo : buildInfoRepository.findAll()) {
			if (buildInfo.getId() > mostCurrentId) {
				mostCurrentId = buildInfo.getId();
				mostCurrentBuildInfo = buildInfo;
			}
		}
		
		return mostCurrentBuildInfo;
	}
	
	public String getBuildModel() {
		log.info("BuildInfoServiceImpl - getBuildModel()");
		List<BuildItemDto> buildItems = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		String response = null;
		
		String json = readGitProperties();
		log.trace("BuildInfoServiceImpl - getBuildModel() - json: " + json);
		
		// for test purposes, unmarked below line of code, i.e. json =  NO_BUILD_DATA; 
		//json =  NO_BUILD_DATA;  
		// insure the above line is marked before pushing to production
		if (json.contentEquals(NO_BUILD_DATA)) {
			log.info("BuildInfoServiceImpl - getBuildModel() - no build data available - "
			        + "using buildInfoService as workaround");
			BuildInfo buildInfo = getLatestBuildInfo();
			
			if (null != buildInfo) {
			    log.info("BuildInfoServiceImpl - getBuildModel() - buildInfo is NOT null");
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.BRANCH, buildInfo.getBranch()));
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.HOST, buildInfo.getHost()));
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.VERSION, buildInfo.getVersion()));
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.COMMIT_TIME, buildInfo.getCommitTime()));
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.COMMIT_ID_SHORT, buildInfo.getCommitIdShort()));
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.COMMIT_ID_LONG, buildInfo.getCommitIdLong()));
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.COMMIT_MSG_SHORT, buildInfo.getCommitMsg()));
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.ORIGIN_URL, buildInfo.getOriginUrl()));
			     
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
			    log.info("BuildInfoServiceImpl - getBuildModel() - buildInfo is NULL");
			    buildItems.add(createBuildItem(BuildInfoServiceImpl.ERROR_TYPE, BuildInfoServiceImpl.ERROR_MSG));
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
		    log.info("BuildInfoServiceImpl - getBuildModel() - returning git.properties information");
			Gson gson = new Gson();
			Type stringMap = new TypeToken<Map<String, String>>() {}.getType();
			Map<String, String> map = gson.fromJson(json, stringMap);
			buildItems.add(createBuildItem(BuildInfoServiceImpl.BRANCH, map.get(BuildInfoServiceImpl.GIT_BRANCH)));
			buildItems.add(createBuildItem(BuildInfoServiceImpl.HOST, map.get(BuildInfoServiceImpl.GIT_BUILD_HOST)));
			buildItems.add(createBuildItem(BuildInfoServiceImpl.VERSION, map.get(BuildInfoServiceImpl.GIT_BUILD_VER)));
			buildItems.add(createBuildItem(BuildInfoServiceImpl.BUILD_TIME, map.get(BuildInfoServiceImpl.GIT_BUILD_TIME)));
			buildItems.add(createBuildItem(BuildInfoServiceImpl.COMMIT_ID_SHORT,	map.get(BuildInfoServiceImpl.GIT_COMMIT_ID_ABRV)));
			buildItems.add(createBuildItem(BuildInfoServiceImpl.COMMIT_MSG_SHORT, map.get(BuildInfoServiceImpl.GIT_COMMIT_MSG_SHORT)));
			buildItems.add(createBuildItem(BuildInfoServiceImpl.COMMIT_TIME, map.get(BuildInfoServiceImpl.GIT_COMMIT_TIME)));
			buildItems.add(createBuildItem(BuildInfoServiceImpl.ORIGIN_URL, map.get(BuildInfoServiceImpl.GIT_REMOTE_ORIGIN_URL)));
			
			sb.append(System.lineSeparator());
			sb.append("Build Information: " + System.lineSeparator());
			ListIterator<BuildItemDto> buildItemData = buildItems.listIterator();
		
			while (buildItemData.hasNext()) {
			    BuildItemDto buildItemDto = buildItemData.next();
			    sb.append("  " + buildItemDto.getType() + " : " + buildItemDto.getValue() + System.lineSeparator());
			}
			response = sb.toString(); 
		}
		
		log.trace("BuildInfoServiceImpl - getBuildModel() - returning: " + response);
		return response;
	}
	
	
	private BuildItemDto createBuildItem(String type, String value) {
		log.trace("BuildInfoServiceImpl - createBuildItem() - type: " + type + " value: " + value);
		BuildItemDto buildItem = new BuildItemDto(type, value);
		log.trace("BuildInfoServiceImpl - createBuildItem() - buildItem: " + buildItem.toString());
		return buildItem;
	}

	private String readGitProperties() {
		log.debug("BuildInfoServiceImpl - readGitProperties - ");
		ClassLoader classLoader = getClass().getClassLoader();
		log.trace("BuildInfoServiceImpl - readGitProperties - classLoader: " + classLoader);
		InputStream inputStream = classLoader.getResourceAsStream("git.properties");
		log.trace("BuildInfoServiceImpl - readGitProperties - inputStream: " + inputStream);
		if (inputStream == null) {
			log.debug("BuildInfoServiceImpl - readGitProperties - inputStream is null -> returning null");
			return NO_BUILD_DATA; 
		}

		try {
			String input = readFromInputStream(inputStream);
			log.trace("BuildInfoServiceImpl - readGitProperties - input: " + input);
			return input;
		} catch (IOException e) {
			log.error("BuildInfoServiceImpl - readGitProperties - input exception: " + e.getMessage());
			e.printStackTrace();
			return NO_BUILD_DATA;
		}
	}

	private String readFromInputStream(InputStream inputStream) throws IOException {
		log.debug("BuildInfoServiceImpl - readFromInputStream: ");
		StringBuilder resultStringBuilder = new StringBuilder();

		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			String line;
			while ((line = br.readLine()) != null) {
				resultStringBuilder.append(line).append("\n");
			}
		}

		String result = resultStringBuilder.toString();
		log.debug("BuildInfoServiceImpl - readFromInputStream - result: " + result);
		return result;

	}
	

}
