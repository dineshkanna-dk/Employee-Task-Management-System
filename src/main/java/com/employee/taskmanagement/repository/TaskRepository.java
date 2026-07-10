package com.employee.taskmanagement.repository;

import com.employee.taskmanagement.model.Task;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class TaskRepository {


    private final Map<Long, Task> taskMap = new HashMap<>();


    public Task save(Task task) {
        taskMap.put(task.getTaskId(), task);
        return task;
    }


    public Collection<Task> findAll() {
        return taskMap.values();
    }


    public Task findById(Long taskId) {
        return taskMap.get(taskId);
    }


    public void deleteById(Long taskId) {
        taskMap.remove(taskId);
    }


    public boolean existsById(Long taskId) {
        return taskMap.containsKey(taskId);
    }
}