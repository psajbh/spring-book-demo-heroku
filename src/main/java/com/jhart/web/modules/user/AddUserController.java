package com.jhart.web.modules.user;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhart.domain.User;
import com.jhart.orchestration.user.UserConductor;

@Controller
public class AddUserController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private UserConductor conductor;
	
	public AddUserController(UserConductor conductor) {
		this.conductor = conductor;
	}
	
	@GetMapping("user/add")
	public String addNewUser(Model model) {
		log.debug("addNewUser- start");
		model.addAttribute("users", conductor.getAllUsers());
		model.addAttribute("user", new User());
		log.debug("addNewUser- finished");
		return "users/newuser";
	}
	
	@RequestMapping(value="/user/add",params="cancel",method=RequestMethod.POST)
	public String cancelNewUser(User user) {
		//log.debug("cancelNewTodo- redirect:/index");
		return "redirect:/users/index";
	}
	
	@RequestMapping(value="/user/add", params="submit", method=RequestMethod.POST)
	public String saveNewUser(User user) {
		log.debug("saveNewUser - start");
		
		if (StringUtils.isEmpty(user.getName())){
			log.warn("saveNewUser - cannot persist user name");
			return "redirect:/users/index";
		}

		for (User existingUser : conductor.getAllUsers()){
			if (existingUser.getName().equals(user.getName())) {
				if (existingUser.getName().contentEquals(user.getName())) {
					log.warn("saveNewUser - attempting to add a duplicate user: " + user.getName());
					return "redirect:/users/index";
				}
			}
		}
		
		user.setDateCreated(new Date());
		User persistedUser = conductor.save(user);
		log.debug("saveNewUser - saved user: " + persistedUser.getName());
		return "redirect:/users/index";		
	}

}
