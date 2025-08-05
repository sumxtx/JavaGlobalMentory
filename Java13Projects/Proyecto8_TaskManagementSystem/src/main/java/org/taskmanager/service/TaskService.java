package org.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.taskmanager.modelo.Task;
import org.taskmanager.repo.ITaskRepo;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private ITaskRepo taskRepo;

    @Override
    public List<Task> listTasks() {
        return taskRepo.findAll();
    }

    @Override
    public Task findTaskById(Integer idTask) {
        Task task = taskRepo.findById(idTask).orElse(null);
        return task;
    }

    @Override
    public void saveTask(Task task) {
        taskRepo.save(task);
    }

    @Override
    public void deleteTask(Task task) {

    }
}
