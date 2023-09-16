package com.jhart.orchestration.user;

import java.util.List;

import com.jhart.domain.User;
import com.jhart.dto.GenericResponseDto;
import com.jhart.dto.UserBackBean;

public interface UserConductor {
	
	GenericResponseDto<List<UserBackBean>> updateUser(UserBackBean userBackBean);
	List<User> getAllUsers();
	User save(User user);
	String deleteUser(Long id);
	List<UserBackBean> getAllUserBackBeans();
	

}
