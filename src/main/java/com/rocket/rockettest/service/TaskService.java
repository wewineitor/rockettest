package com.rocket.rockettest.service;

import com.rocket.rockettest.entity.Task;
import com.rocket.rockettest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void createTask(Task taskDetails) {
        taskRepository.save(taskDetails);
    }

    public void updateTask(Long id, Task taskDetails) {
        taskRepository.update(id, taskDetails);
    }

    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }
}
