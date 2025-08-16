package org.taskmanager;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.taskmanager.presentation.TaskManagerFx;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
public class TaskManager {
    public static void main(String[] args) {
        //SpringApplication.run(TaskManager.class, args);
        Application.launch(TaskManagerFx.class, args);
    }
}