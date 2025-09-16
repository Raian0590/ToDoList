package com.raian.todo_list.controllers;

import com.raian.todo_list.entities.Task;
import com.raian.todo_list.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    public TaskService taskService;

    @GetMapping
    public ResponseEntity<List<Task>> listAll() {
        List<Task> list = taskService.listAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Task> findById(@PathVariable Long id) {
        Task task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {
        task = taskService.create(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(task);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
        task = taskService.update(id, task);
        return ResponseEntity.ok(task);
    }
}
