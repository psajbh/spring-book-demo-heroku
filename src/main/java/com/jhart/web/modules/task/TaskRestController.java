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
//import org.springframework.web.context.request.RequestContextHolder;
//import org.springframework.web.context.request.ServletRequestAttributes;

import com.jhart.dto.TodoBackBean;
//import com.jhart.dto.UserBackBean;
import com.jhart.orchestration.task.TaskConductor;
//import com.jhart.orchestration.task.impl.TaskConductorImpl;

@RestController
@Validated
public class TaskRestController {
	Logger log = LoggerFactory.getLogger(TaskRestController.class);
	
	private TaskConductor conductor;
	
	public TaskRestController(TaskConductor conductor) {
		log.info("created TaskRestController with " + conductor.toString());
		this.conductor = conductor;
	}
	
	@GetMapping({"todoDataTable"})
	public ResponseEntity<Object> getAllTasks() {
		log.debug("getAllTasks- start");
		
		//not currently used.
		//HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		//UserBackBean ubb = (UserBackBean) request.getAttribute("credentialKey");

		List<TodoBackBean> todoBackBeans = null;
		boolean success = false;
		
		try {
			todoBackBeans =  conductor.getAllTodoBackBeans();
			log.debug("captured todoBackBeans: " + todoBackBeans);
			success = true;
		}
		catch(Exception e) {
			log.error(e.getMessage(),e);
		}
		
		log.debug("getAllTasks- success: " + success);
		
		if (success) {
			log.debug("getAllTask success");
			return new ResponseEntity<Object>(todoBackBeans,HttpStatus.OK);
		}
		
		log.error("getAllTask failed");
		return new ResponseEntity<Object>("UnAuthenticated User",HttpStatus.I_AM_A_TEAPOT);
	}

	public TaskConductor getConductor() {
		return conductor;
	}

	public void setConductor(TaskConductor conductor) {
		this.conductor = conductor;
	}

}
