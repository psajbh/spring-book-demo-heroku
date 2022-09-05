package com.jhart.web.user;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.jhart.domain.Todo;
import com.jhart.domain.User;
import com.jhart.orchestration.user.UserConductor;
import com.jhart.service.task.TodoService;
import com.jhart.service.user.UserService;

@Controller
public class DeleteUserController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	//UserService userService;
	//TodoService todoService;
	private UserConductor conductor;
	
	public DeleteUserController(UserConductor conductor) {
		this.conductor = conductor;
	}
	
	@PostMapping("user/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		log.debug("deleteUser- start user id: " + id);
		conductor.deleteUser(id);
		log.debug("deleteUser- end");
		return "users/index";
	}

}
