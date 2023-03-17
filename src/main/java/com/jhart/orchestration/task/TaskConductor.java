package com.jhart.orchestration.task;

import java.util.List;

import com.jhart.domain.Todo;
import com.jhart.dto.GenericResponseDto;
import com.jhart.dto.TodoBackBean;

public interface TaskConductor {
	
	GenericResponseDto<List<TodoBackBean>> updateTodo(TodoBackBean todoBackBean);
	Todo save(Todo todo);
	void deleteTodo(Long id);
	List<TodoBackBean> getAllTodoBackBeans() throws Exception;
}
