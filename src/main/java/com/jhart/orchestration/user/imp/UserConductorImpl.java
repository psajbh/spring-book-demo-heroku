package com.jhart.orchestration.user.imp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jhart.domain.Todo;
import com.jhart.domain.User;
import com.jhart.dto.GenericResponseDto;
import com.jhart.dto.UserBackBean;
//import com.jhart.orchestration.user.UserBaseConductor;
import com.jhart.orchestration.user.UserConductor;
import com.jhart.service.task.TodoService;
import com.jhart.service.user.UserService;
import com.jhart.transform.UserTransformer;

@Qualifier("UserConductor")
@Component
public class UserConductorImpl extends UserBaseConductor implements UserConductor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public UserConductorImpl(UserService userService, TodoService todoService, UserTransformer userTransformer) {
		super.userService = userService;
		super.todoService = todoService;
		super.userTransformer = userTransformer;
	}

	@Transactional
	@Override
	public User save(User user) {
		log.debug("UserConductor - saving user: " + user.toString());
		return userService.save(user);
	}

	@Transactional
	@Override
	public String deleteUser(Long id) {
		log.debug("deleteUser- start id: " + id);
		String response = null;
		User user = null;
		String deleteUserName = null;

		try {
			user = userService.findById(id);
			deleteUserName = user.getName();
		} catch (Exception e) {
			log.error("exception - response failure : userService.findById(" + id.toString() + ")" + e.getMessage());
			//return "exception - response failure : userService.findById(" + id.toString() + ")";
		}

		if (null == deleteUserName) {
			response = "No user found with id: " + id;
		} 
		else {
			List<String> playerNameList = (List<String>) userService.getPlayerNameList();

			if (playerNameList.contains(deleteUserName)) {
				response = "user: " + user.getName() + " is a player and cannot be deleted";
				log.debug(response);
			} 
			else {
				Iterator<Todo> todos = todoService.listAll().iterator();
				while (todos.hasNext()) {
					Todo todo = todos.next();
					String todoUsername = todo.getUser().getName();

					if (todoUsername.equals(deleteUserName)) {
						response = "user: " + user.getName() + " is removed from todo: " + todo.getTaskName();
						log.debug(response);
						todo.setUser(null);
						todoService.save(todo);
					}
				}
				userService.delete(user);
				log.debug("deleted user: " +user.getName());
			};

		}
		
		return response;
		//return null;
		//return response;
	}

	@Override
	public List<User> getAllUsers() {
		// log.debug("getAllUsers- start");
		List<User> userAccumulator = new ArrayList<>();
		Iterator<User> users = userService.listAll().iterator();
		while (users.hasNext()) {
			User user = users.next();
			userAccumulator.add(user);
		}
		// log.debug("getAllUsers- done");
		return userAccumulator;
	}

	@Override
	public List<UserBackBean> getAllUserBackBeans() {
		// log.debug("getAllUserBackBeans- start");
		List<UserBackBean> userBackBeanAccumulator = new ArrayList<>();
		Iterator<User> users = userService.listAll().iterator();
		while (users.hasNext()) {
			UserBackBean userBackBean = userTransformer.convertUserToUserBackBean(users.next());
			userBackBeanAccumulator.add(userBackBean);
		}

		// log.debug("getAllUserBackBeans- done");
		return userBackBeanAccumulator;
	}

	@Transactional
	@Override
	public GenericResponseDto<List<UserBackBean>> updateUser(UserBackBean userBackBean) {
		// log.debug("updateUser- start");
		User user = userService.findById(userBackBean.getId());

		if (null != user) {
			// log.debug("updateUser- user found in database");
			User transformedUser = userTransformer.convertUserBackBeanToUser(userBackBean);
			try {
				userService.save(transformedUser);
				// log.debug("updateUser- user updated and persisted");
				return new GenericResponseDto<>("success", getUserList());
			} catch (Exception e) {
				if (e.getCause().getMessage().contains("Unique index or primary key violation")) {
					// log.error("updateUser- constraint violation exception", e);
				} else {
					// log.error(e.getMessage(), e);
				}
			}
			// log.debug("updateUser- returning failure");
			return new GenericResponseDto<>("failure", getUserList());
		} else {
			// log.debug("updateUser- user not found in database");
			return new GenericResponseDto<>("failure", getUserList());
		}
	}

}
