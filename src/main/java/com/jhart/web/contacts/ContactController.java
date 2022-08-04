package com.jhart.web.contacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jhart.web.user.UserRestController;

@Controller
public class ContactController {
	Logger log = LoggerFactory.getLogger(ContactController.class);
	
	@GetMapping({"/contacts/contacts"})
	public String contacts() {
		log.debug("contacts- start");
		return "contacts/contacts";
	}


}
