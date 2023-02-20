package com.jhart.service.buildinfo;

import com.jhart.domain.BuildInfo;

public interface BuildInfoService {
	BuildInfo getLatestBuildInfo();
	String getBuildModel();
}
