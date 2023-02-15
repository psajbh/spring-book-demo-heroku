package com.jhart.service.buildinfo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.jhart.domain.BuildInfo;
import com.jhart.repo.buildinfo.BuildInfoRepository;
import com.jhart.repo.spinners.SpinnersRepository;

@Service
public class BuildInfoServiceImpl implements BuildInfoService{
	Logger log = LoggerFactory.getLogger(this.getClass());
	private final BuildInfoRepository buildInfoRepository;
	
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

}
