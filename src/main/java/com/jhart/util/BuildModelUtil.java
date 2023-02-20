package com.jhart.util;

import org.apache.maven.model.Model;

public class BuildModelUtil {
	private Model model;
	
	public BuildModelUtil() {}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

    @Override
    public String toString() {
        return "BuildModel [model=" + model + "]";
    }
	
}
