package com.jhart.web.about;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhart.util.ConfigPropertyBuilder;

@Controller
public class ConfigPropertyController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	ConfigPropertyBuilder configPropertyBuilder;
	
	public ConfigPropertyController(ConfigPropertyBuilder configPropertyBuilder) {
		this.configPropertyBuilder = configPropertyBuilder;
	}
	
	@GetMapping("keyprops")
	public String getKeyProperties(Model model) {
		log.info("ConfigPropertyController - getKeyProperties()");
		model.addAttribute("data", configPropertyBuilder.getConfigProperties());
		return "about/keyprops";
	}

}
