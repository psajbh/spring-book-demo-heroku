package com.jhart.web.modules.task;

import java.util.List;

//import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jhart.dto.TodoBackBean;
import com.jhart.orchestration.task.TaskConductor;

@RestController
@Validated
public class TaskRestController {
	Logger log = LoggerFactory.getLogger(TaskRestController.class);
	private TaskConductor conductor;
	
	public TaskRestController(TaskConductor conductor) {
		this.conductor = conductor;
	}
	
	@GetMapping({"todoDataTable"})
	public ResponseEntity<Object> getAllTasks() {
		log.debug("getAllTasks- start");
		boolean success = false;
		List<TodoBackBean> todoBackBeans =  conductor.getAllTodoBackBeans();
		if (null != todoBackBeans) {
			success = true;
		}
		
		if (success) {
			return new ResponseEntity<Object>(todoBackBeans,HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(null,HttpStatus.I_AM_A_TEAPOT);
	}

}
