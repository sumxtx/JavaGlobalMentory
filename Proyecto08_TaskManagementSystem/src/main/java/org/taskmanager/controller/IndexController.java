package org.taskmanager.controller;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.taskmanager.modelo.Task;
import org.taskmanager.service.TaskService;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.*;
import org.w3c.dom.Text;

@Component
public class IndexController implements Initializable {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    public TextField infoField;

    @Autowired
    private TaskService taskService;

    @FXML
    private TableView<Task> taskTable;

    @FXML
    private TableColumn<Task, Integer> tableColID;

    @FXML
    private TableColumn<Task, String> tableColTask;

    @FXML
    private TableColumn<Task, String> tableColPerson;

    @FXML
    private TableColumn<Task, String> tableColStatus;

    private final ObservableList<Task> taskList = FXCollections.observableArrayList();

    @FXML
    private TextField taskNameField;

    @FXML
    private TextField personField;

    @FXML
    private TextField statusField;

    private Integer idTaskInternal;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        taskTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        configColumns();
        listTasks();
    }

    private void listTasks() {
        logger.info("Listing tasks");
        taskList.clear();
        taskList.addAll(taskService.listTasks());
        taskTable.setItems(taskList);
    }

    private void configColumns() {
        tableColID.setCellValueFactory(new PropertyValueFactory<>("idTask"));
        tableColTask.setCellValueFactory(new PropertyValueFactory<>("taskName"));
        tableColPerson.setCellValueFactory(new PropertyValueFactory<>("person"));
        tableColStatus.setCellValueFactory(new PropertyValueFactory<>("estatus"));
    }

    public void addTask(){
        if(taskNameField.getText().isEmpty()){
            showMessage("Validation Error", "Insert Task");
            taskNameField.requestFocus();
            return;
        }
        else {
            var task = new Task();
            parseFormData(task);
            task.setIdTask(null);
            taskService.saveTask(task);
            showMessage("Info", "Task Successfully Added");
            cleanForm();
            listTasks();
        }
    }

    public void loadTaskForm(){
        var task = taskTable.getSelectionModel().getSelectedItem();
        if(task != null){
           idTaskInternal = task.getIdTask();
           taskNameField.setText(task.getTaskName());
           personField.setText(task.getPerson());
           statusField.setText(task.getEstatus());

        }
    }
    private void parseFormData(Task task){
        if(idTaskInternal != null){
            task.setIdTask(idTaskInternal);
        }
        task.setTaskName(taskNameField.getText());
        task.setPerson(personField.getText());
        task.setEstatus(statusField.getText());
    }

    public void modifyTask(){
        if(idTaskInternal == null){
            showMessage("Info", "Please Select a Task to Modify");
            return;
        }
        if(taskNameField.getText().isEmpty()){
            showMessage("Error", "Insert Task");
            taskNameField.requestFocus();
            return;
        }
        var task = new Task();
        parseFormData(task);
        taskService.saveTask(task);
        showMessage("Info", "Task Has Been Modified");
        cleanForm();
        listTasks();

    }

    public void cleanForm(){
        idTaskInternal = null;
        taskNameField.clear();
        personField.clear();
        statusField.clear();
    }

    public void deleteTask(){
        var task = taskTable.getSelectionModel().getSelectedItem();
        if(task != null){
            logger.info("Task to delete: " + task.toString());
            taskService.deleteTask(task);
            showMessage("Info", "Task Successfully Removed");
            cleanForm();
            listTasks();
        }
        else{
            showMessage("Error", "No Task Has Been Selected");
        }
    }

    private void showMessage(String title, String message){
        /*
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
        */
        infoField.setText(title + " : " + message);
    }
}
