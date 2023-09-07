package com.jhart.service.task;

import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jhart.domain.Todo;
import com.jhart.repo.task.TodoRepository;

@Service
public class TodoServiceImpl implements TodoService {
	Logger log = LoggerFactory.getLogger(TodoServiceImpl.class);
	private TodoRepository todoRepository;
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		log.debug("TodoServiceImpl- constructor");
		this.todoRepository = todoRepository;
	}
	
	@Transactional
	@Override
	public void delete(Todo todo) {
		log.debug("TodoServiceImpl- delete: " + todo.getTaskName());
		todoRepository.delete(todo);
	}

	@Transactional
	@Override
	public Todo save(Todo todo) {
		log.debug("TodoServiceImpl- save: " + todo.getTaskName());
		return todoRepository.save(todo);
	}

	@Transactional(readOnly = true)
	@Override
	public Iterable<Todo> listAll() {
		log.debug("TodoServiceImpl- calling listAll");
		return todoRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Todo findById(Long id){
		log.debug("TodoServiceImpl- findById: " + id); 
		Iterator<Todo> todos = this.listAll().iterator();
		while(todos.hasNext()){
			Todo todo = todos.next();
			if (todo.getId().equals(id)) {
				log.debug("TodoServiceImpl- findById returning " + todo.getTaskName());
				return todo;
			}
		}
		log.debug("TodoServiceImpl- findById returning null");
		return null;
	}
	

}
