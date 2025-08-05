package org.taskmanager.service;

import org.taskmanager.modelo.Task;

import java.util.List;

public interface ITaskService {
    public List<Task> listTasks();
    public Task findTaskById(Integer idTask);
    public void saveTask(Task task);
    public void deleteTask(Task task);
}
