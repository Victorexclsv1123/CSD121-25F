package lab6;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Pos;


import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;


public class Main extends Application {


    private final ObservableList<String> tasks = FXCollections.observableArrayList();
    private ListView<String> taskListView;
    private TextField inputField;
    private static final String NOT_COMPLETED = " (Not completed)";
    private static final String COMPLETED = " (Completed)";
    private Label tasksRemainingLabel;
    private Label tasksCompletedLabel;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("To-Do List");

        // a vertical box layout with 10px spacing between elements and 15px padding
        // in the edges of layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));



        //add new task to the list
        HBox inputBox = new HBox(10);
        inputField = new TextField();
        inputField.setPromptText("Enter a new task...");
        Button addButton = new Button("Add");
        addButton.setOnAction(this::handleAdd);
        inputBox.getChildren().addAll(inputField, addButton);

        // ListView to display tasks
        taskListView = new ListView<>(tasks);
        taskListView.setPrefHeight(200);

        tasksRemainingLabel = new Label("Tasks remaining: 0");
        tasksCompletedLabel = new Label("Tasks completed: 0");

        HBox countsRow = new HBox(20); // 20px spacing between labels
        countsRow.getChildren().addAll(tasksRemainingLabel, tasksCompletedLabel);
        countsRow.setAlignment(Pos.CENTER_LEFT);


        Button CompleteButton = new Button("Mark Completed");
        CompleteButton.setOnAction(this::handleMarkCompleted);

        Button UnCompleteButton = new Button("Unmark Completed");
        UnCompleteButton.setOnAction(this::handleUnmark);

        HBox markRow = new HBox(10);   // 10px spacing
        markRow.getChildren().addAll(CompleteButton, UnCompleteButton);
        markRow.setAlignment(Pos.CENTER_LEFT);


        // Button to remove selected task
        Button RemoveButton = new Button("Remove Selected");
        RemoveButton.setOnAction(this::handleRemove);


        // Button to save tasks to file
        Button SaveButton = new Button("Save");
        SaveButton.setOnAction(e -> saveTasksToFile());



        //ui elements
        root.getChildren().addAll(new Label("My Tasks:"), taskListView, inputBox,markRow,RemoveButton,
                SaveButton, countsRow);

        // Set up and show the scene
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //add tasked when the add button is clicked
    private void handleAdd(ActionEvent event) {
        String task = inputField.getText().trim();
        if (!task.isEmpty()) {
            tasks.add(task);
            inputField.clear();
        }

        updateTaskCounts();

    }

    // mark the selected task as completed
    private void handleMarkCompleted(ActionEvent event) {
        int index = taskListView.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            return; // nothing selected
        }

        String current = tasks.get(index);

        // if already completed, do nothing
        if (current.endsWith(COMPLETED)) {
            return;
        }

        // strip "(Not completed)" if present, then add "(Completed)"
        if (current.endsWith(NOT_COMPLETED)) {
            current = current.substring(0, current.length() - NOT_COMPLETED.length());
        }
        tasks.set(index, current + COMPLETED);

        updateTaskCounts();

    }

    private void handleUnmark(ActionEvent event) {
        int index = taskListView.getSelectionModel().getSelectedIndex();
        if (index < 0) {
            return; // nothing selected
        }

        String current = tasks.get(index);

        // Already not completed?
        if (current.endsWith(NOT_COMPLETED)) {
            return;
        }

        // Strip "(Completed)" and restore "(Not completed)"
        if (current.endsWith(COMPLETED)) {
            current = current.substring(0, current.length() - COMPLETED.length());
        }

        tasks.set(index, current + NOT_COMPLETED);

        // Update counts
        updateTaskCounts();
    }



    //to remove the selected task
    private void handleRemove(ActionEvent event) {
        String selected = taskListView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tasks.remove(selected);
        }
        updateTaskCounts();

    }

    //file name for saving tasks
    private static final String FILE_NAME = "tasks.txt";

    private void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String task : tasks) {
                writer.write(task);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateTaskCounts() {
        int completed = 0;
        int notCompleted = 0;

        for (String t : tasks) {
            if (t.endsWith(COMPLETED)) {
                completed++;
            } else {
                notCompleted++;
            }
        }

        tasksRemainingLabel.setText("Tasks remaining: " + notCompleted);
        tasksCompletedLabel.setText("Tasks completed: " + completed);
    }




}



