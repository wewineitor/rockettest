package com.rocket.rockettest.controller;

import com.rocket.rockettest.entity.Task;
import com.rocket.rockettest.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@Tag(name = "Task Controller", description = "Se encarga de las operaciones de escritura (creación, eliminación y actualización) relacionadas con las tareas.")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    @Operation(summary = "Obtener todas las tareas", description = "Devuelve una lista con todas las tareas disponibles")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear una nueva tarea", description = "Crea una nueva tarea con los datos proporcionados")
    public ResponseEntity<Void> createTask(@RequestBody Task taskDetails) {
        taskService.createTask(taskDetails);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una tarea", description = "Actualiza una tarea con los datos proporcionados")
    public ResponseEntity<Void> updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        taskService.updateTask(id, taskDetails);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una tarea", description = "Elimina una tarea basada en su ID")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
