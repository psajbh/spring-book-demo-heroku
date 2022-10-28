package com.jhart.web.three13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/", "/313"})
public class Three13Controller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	public Three13Controller() {		
	}
	
	@GetMapping({"/index"})
	public String index(Model model) {
		//WordSupportDto wordSupportDto = new WordSupportDto();
		//model.addAttribute("wordSupportDto", wordSupportDto);
		log.info("Three13Controller - index");
		return "313/index";
	}

}
