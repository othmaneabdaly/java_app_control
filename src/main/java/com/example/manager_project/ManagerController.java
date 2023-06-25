package com.example.manager_project;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ManagerController {
    @FXML
    TextField managerID;
    @FXML
    TextField ManagerName;
    @FXML
    ComboBox ManagerType;
    @FXML
    TextField HoursWorked;
    @FXML
    ListView ManagerList;
    @FXML
    public void onAddButtonClick()throws IOException {

        float Hours = Float.parseFloat(HoursWorked.getText());
        String id = managerID.getText();
        String nom = ManagerName.getText();
        serial wr = new serial(new File("Manager.txt"));
        if(ManagerType.getValue().equals("Senior")){
            Senior ms = new Senior(id,nom,Hours);
            ManagerList.getItems().add("ID : "+id+" Nom : "+nom+" Heurs : "+Hours+" Cout : "+ms.calculercout());
            wr.write(ms);
        }else{
            Junior mj = new Junior(id,nom,Hours);
            ManagerList.getItems().add("ID : "+id+" Nom : "+nom+" Heurs : "+Hours+" Cout : "+mj.calculercout());
            wr.write(mj);
        }

    }
    @FXML
    public void onCoutButtonClick()throws IOException{
        float Hours = Float.parseFloat(HoursWorked.getText());
        String id = managerID.getText();
        String nom = ManagerName.getText();
        serial wr = new serial(new File("Manager.txt"));
        if(ManagerType.getValue().equals("Senior")){
            Senior ms = new Senior(id,nom,Hours);
            wr.write(ms);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Cout du manager");
            a.setHeaderText("Calcul du cout du manager");
            a.setContentText(String.valueOf(ms.calculercout()));
            a.show();
        }else{
            Junior mj = new Junior(id,nom,Hours);
            wr.write(mj);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Cout du manager");
            a.setHeaderText("Calcul du cout du manager");
            a.setContentText(String.valueOf(mj.calculercout()));
            a.show();
        }
    }
    @FXML
    public void onRecapButtonClick()throws IOException {
        serial wr = new serial(new File("Manager.txt"));
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        Set<Manager> s = new HashSet<Manager>();
        s=wr.read();
        a.setTitle("Data Stored");
        a.setHeaderText("Recap");
        String s1 = "";
        for (Manager m:s){
            s1+="ID : "+m.ManagerID+" Name : "+m.Name+" Hours : "+m.HoursWorked+"\n";
        }
        a.setContentText(s1);
        a.show();
    }
}
