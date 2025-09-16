package com.raian.todo_list.services;

import com.raian.todo_list.entities.Task;
import com.raian.todo_list.exceptions.TaskNotFoundException;
import com.raian.todo_list.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    public TaskRepository taskRepository;

    public List<Task> listAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found! id: " + id));
        return task;
    }

    public Task create(Task task) {
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException("Task not found! id: " + id);
        }
        taskRepository.deleteById(id);
    }

    public Task update(Long id, Task task) {
        Task entity = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found! id: " + id));
        updateData(entity, task);
        return taskRepository.save(entity);
    }

    private void updateData(Task entity, Task task) {
        entity.setName(task.getName());
        entity.setDescription(task.getDescription());
    }
}