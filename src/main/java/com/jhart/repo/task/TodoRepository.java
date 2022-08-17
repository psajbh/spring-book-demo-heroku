package com.jhart.repo.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.jhart.domain.Todo;

@Repository("todoRepository")
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
