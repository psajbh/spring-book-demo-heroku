package com.jhart.web.modules.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.jhart.domain.Todo;
import com.jhart.orchestration.task.TaskConductor;
import com.jhart.service.user.UserService;

@Controller
public class AddTaskController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	private UserService userService;
	private TaskConductor conductor;
	
	public AddTaskController(UserService userService, TaskConductor conductor) {
		this.userService = userService;
		this.conductor = conductor;
	}
	
	@GetMapping("task/add")
	public String addNewTodo(Model model) {
		log.debug("addNewTodo- start");
		model.addAttribute("users", userService.listAll());
		model.addAttribute("todo", new Todo());
		return "task/newtodo";
	}

	@RequestMapping(value="/todo/add",params="cancel",method=RequestMethod.POST)
	public String cancelNewTodo(Todo todo) {
		log.debug("cancelNewTodo- redirect:/index");
		return "redirect:/task/index";
	}
	
	@RequestMapping(value="/todo/add", params="submit", method=RequestMethod.POST)
	public String saveNewTodo(Todo todo) {
		log.debug("saveNewTodo- " + todo.toString());
		
		if (ObjectUtils.isEmpty(todo.getTaskName()) || ObjectUtils.isEmpty(todo.getUser())){
			log.warn("saveNewTodo- cannot persist task without a task name or a task owner (user)");
			return "redirect:/task/index";
		}
		
		Todo savedTodo = conductor.save(todo);
		if (null == savedTodo) {
			log.warn("failed to add new todoTodo " );
		}
		else {
			log.debug("saveNewTodo- saved todo: " + savedTodo.toString());
		}

		return "redirect:/task/index";		
	}

}
