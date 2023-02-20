package com.jhart.web.modules.contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ContactController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping({"/contacts/contacts"})
	public String contacts() {
		log.debug("contacts- start");
		return "contacts/contacts";
	}


}
