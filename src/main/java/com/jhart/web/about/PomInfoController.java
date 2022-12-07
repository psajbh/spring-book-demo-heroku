package com.jhart.web.about;

import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhart.util.BuildModel;


@Controller
public class PomInfoController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private BuildModel buildModel;
	
	public PomInfoController(BuildModel buildModel) {
		log.warn("PomInfoController -");
		this.buildModel = buildModel;
	}
	
	@GetMapping("pomInfo")
	public String pomInfo(org.springframework.ui.Model model) {
		log.warn("pomInfo -");
		String buildModel = getBuildModel();
		log.warn("PomInfoController - buildInfo -" + buildModel);
		model.addAttribute("data", buildModel);
		return "about/pomInfo";
	}
	
	// move this to a service
	public String getBuildModel() {
		Model model = buildModel.getModel();
		StringBuilder sb = new StringBuilder();
		sb.append(System.lineSeparator());
		sb.append("Latest Commit Date:  " + "Wed Dec 7 15:07:23 2022 -0500");
		sb.append(System.lineSeparator());
		sb.append("Latest Commit Value: " + "51741ce70781e58e5c2672b3f19303d3b2aa90a4");
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append("Project Data:" + System.lineSeparator());
		sb.append("    groupId: " + model.getGroupId() + System.lineSeparator());
		sb.append("    artifactId: " + model.getArtifactId() + System.lineSeparator());
		sb.append("    version: " + model.getVersion() + System.lineSeparator());
		sb.append("    packaging: " + model.getPackaging() + System.lineSeparator());
		sb.append("    name: " + model.getName() + System.lineSeparator()+ System.lineSeparator());
		
		sb.append("Parent Project: " +  System.lineSeparator()) ;
		sb.append("    " + model.getParent().getArtifactId() + " - " + model.getParent().getVersion() +  System.lineSeparator() +  System.lineSeparator());
		
		sb.append("Properties: " + System.lineSeparator());
		Properties props = model.getProperties();
		Set<String> keys = props.stringPropertyNames();
		for (String key : keys) {
			String value = (String)props.get(key);
			sb.append("     key: " + key + " value: " + value + System.lineSeparator());
		}
		sb.append(System.lineSeparator());
		sb.append("Dependencies: " + System.lineSeparator());
		
		List<Dependency> dependencies = model.getDependencies();
		for (Dependency dependency : dependencies) {
			String dependencyGroupId = dependency.getGroupId();
			String dependencyArtificatId = dependency.getArtifactId();
			String depenencyVersion = dependency.getVersion();
			sb.append("      " +  dependencyGroupId + " : "+ dependencyArtificatId 
					+  getDependencyVersion(depenencyVersion) +  System.lineSeparator());
			
		}
		
		//log.debug(sb.toString());
		return sb.toString();
	}
	
	private String getDependencyVersion(String version) {
		if (version == null) {
			return "";
		}
		else {
			return " - " + version;
		}
		
	}

}
