package com.example.manager_project;

import java.io.Serializable;

public abstract class Manager implements Serializable {
    String ManagerID;
    String Name;
    float    HoursWorked;
    public Manager(String managerID, String name, float hoursWorked) {
        ManagerID = managerID;
        Name = name;
        HoursWorked = hoursWorked;
    }
    abstract float calculercout();


}
