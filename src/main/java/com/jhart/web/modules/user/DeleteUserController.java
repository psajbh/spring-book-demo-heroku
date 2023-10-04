package com.jhart.web.modules.user;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhart.orchestration.user.UserConductor;

@Controller
public class DeleteUserController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private UserConductor conductor;
	
	public DeleteUserController(UserConductor conductor) {
		this.conductor = conductor;
	}
	
	@PostMapping("user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		log.debug("deleteUser- start user id: " + id);
		String result = conductor.deleteUser(id);
		log.debug("deleteUser - end: " + result);
		return "users/index";
	}

}
