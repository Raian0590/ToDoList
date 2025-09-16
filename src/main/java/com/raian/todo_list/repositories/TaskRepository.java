package com.raian.todo_list.repositories;

import com.raian.todo_list.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
