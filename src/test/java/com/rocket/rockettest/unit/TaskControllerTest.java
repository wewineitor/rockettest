package com.rocket.rockettest.unit;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rocket.rockettest.controller.TaskController;
import com.rocket.rockettest.entity.Task;
import com.rocket.rockettest.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testFindAllTasks() throws Exception {
        Task task1 = new Task();
        task1.setName("Task 1");
        task1.setDescription("Description 1");
        task1.setInitialDate("2024-10-01");

        Task task2 = new Task();
        task2.setName("Task 2");
        task2.setDescription("Description 2");
        task2.setInitialDate("2024-10-02");

        when(taskService.findAll()).thenReturn(Arrays.asList(task1, task2));

        mockMvc.perform(get("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Task 1"))
                .andExpect(jsonPath("$[1].name").value("Task 2"));

        verify(taskService, times(1)).findAll();
    }

    @Test
    public void testCreateTask() throws Exception {
        Task task = new Task();
        task.setName("Task 1");
        task.setDescription("Description 1");
        task.setInitialDate("2024-10-05");

        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isCreated());

        verify(taskService, times(1)).createTask(any(Task.class));
    }

    @Test
    public void testUpdateTask() throws Exception {
        Task task = new Task();
        task.setName("Updated Task");
        task.setDescription("Updated Description");
        task.setInitialDate("2024-11-05");

        mockMvc.perform(put("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk());

        verify(taskService, times(1)).updateTask(eq(1L), any(Task.class));
    }

    @Test
    public void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(taskService, times(1)).deleteTask(1L);
    }
}
