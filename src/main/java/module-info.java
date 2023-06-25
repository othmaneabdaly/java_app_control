module com.example.manager_project {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.manager_project to javafx.fxml;
    exports com.example.manager_project;
}