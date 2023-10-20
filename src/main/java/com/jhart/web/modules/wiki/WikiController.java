package com.jhart.web.modules.wiki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WikiController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@GetMapping({"/resource/main"})
	public String main() {
		log.debug("resource - start");
		return "resource/main";
	}
	
	@GetMapping({"/resource/index"})
	public String wiki() {
		log.debug("resource - start");
		return "resource/index";
	}
	
	@GetMapping({"/angular"})
	public String angular() {
		log.debug("resource - angular");
		return "resource/angular";
	}
	
	@GetMapping({"/baseball"})
	public String baseball() {
		log.debug("resource - baseball");
		return "resource/baseball";
	}
	
	@GetMapping({"/blog"})
	public String blog() {
		log.debug("resource - blog");
		return "resource/blog";
	}

	@GetMapping({"/git"})
	public String git() {
		log.debug("resource - git");
		return "resource/git";
	}
	
	@GetMapping({"/heroku"})
	public String heroku() {
		log.debug("resource - heroku");
		return "resource/heroku";
	}
	
	@GetMapping({"/html"})
	public String html() {
		log.debug("resource - html");
		return "resource/html";
	}
	
	@GetMapping({"/httpclient"})
	public String httpclient() {
		log.debug("resource - httpclient");
		return "resource/httpclient";
	}
	
	@GetMapping({"/ide"})
	public String ide() {
		log.debug("resource - ide");
		return "resource/ide";
	}

	@GetMapping({"/java"})
	public String java() {
		log.debug("resource - java");
		return "resource/java";
	}

	@GetMapping({"/javafx"})
	public String javaFX() {
		log.debug("resource - javafx");
		return "resource/javafx";
	}

	@GetMapping({"/javascript"})
	public String javascript() {
		log.debug("resource - javascript");
		return "resource/javascript";
	}
	
	@GetMapping({"/jquery"})
	public String jquery() {
		log.debug("resource - jquery");
		return "resource/jquery";
	}

	@GetMapping({"/json"})
	public String json() {
		log.debug("resource - json");
		return "resource/json";
	}
	
	@GetMapping({"/maven"})
	public String maven() {
		log.debug("resource - maven");
		return "resource/maven";
	}

	@GetMapping({"/overflow"})
	public String overflow() {
		log.debug("resource - overflow");
		return "resource/overflow";
	}

	@GetMapping({"/spring"})
	public String spring() {
		log.debug("resource - spring");
		return "resource/spring";
	}

	@GetMapping({"/springboot"})
	public String springboot() {
		log.debug("resource - springboot");
		return "resource/springboot";
	}

	@GetMapping({"/thorben"})
	public String thorben() {
		log.debug("resource - thorben");
		return "resource/thorben";
	}
	
	@GetMapping({"/thymeleaf"})
	public String thymeleaf() {
		log.debug("resource - thymeleaf");
		return "resource/thymeleaf";
	}
	
	@GetMapping({"/utility"})
	public String utility() {
		log.debug("resource - utility");
		return "resource/utility";
	}
	
	@GetMapping({"/web"})
	public String web() {
		log.debug("resource - web");
		return "resource/web";
	}

	@GetMapping({"/windows"})
	public String window() {
		log.debug("resource - window");
		return "resource/windows";
	}
	
	@GetMapping({"/video"})
	public String video() {
		log.debug("resource - video");
		return "resource/video";
	}

}
