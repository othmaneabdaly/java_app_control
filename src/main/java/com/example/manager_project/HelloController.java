package com.example.manager_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class HelloController {
    @FXML
    TextField userField;
    @FXML TextField passwordField;
    @FXML TextField managerID;
    @FXML TextField ManagerName;
    @FXML
    ComboBox ManagerType;
    @FXML TextField HoursWorked;
    @FXML
    private Label welcomeText;

    @FXML
    private Button Loginbtn;

    @FXML
    public void onLoginButtonClick(ActionEvent actionEvent) {
        if (Objects.equals(userField.getText(), "admin") && Objects.equals(passwordField.getText(), "admin")) {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ManagerDetails-view.fxml"));
            Stage stage = (Stage) userField.getScene().getWindow();
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setScene(scene);
            stage.show();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Authentification Error");
            a.setHeaderText("Username or Password Invalid");
            a.setContentText("Re-enter Username and Password");
            a.show();
        }
    }
}