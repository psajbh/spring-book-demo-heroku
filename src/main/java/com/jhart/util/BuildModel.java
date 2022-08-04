package com.jhart.util;

import org.apache.maven.model.Model;

//import lombok.Getter;
//import lombok.Setter;

// supports AppConfig in capturing pom.xml information.
//@Setter
//@Getter
public class BuildModel {
	private Model model;
	
	public BuildModel() {
		
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
	
	
	
}
