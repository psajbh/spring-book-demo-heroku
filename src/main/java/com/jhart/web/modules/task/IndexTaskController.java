package com.jhart.web.modules.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexTaskController {
	Logger log = LoggerFactory.getLogger(IndexTaskController.class);
	
	@GetMapping({"/task/index"})
	public String index(Model model) {
		log.info("IndexTaskController - index");
		return "task/index";
	}

}
