package com.example.manager_project;

class Senior extends Manager {

    public Senior(String managerID, String name, float hoursWorked) {
        super(managerID, name, hoursWorked);
    }

    @Override
    float calculercout() {
        if (this.HoursWorked >2000) return 2500*2000+(this.HoursWorked -2000)*3500;
        else if (this.HoursWorked<2000) {
            return this.HoursWorked*2000;
        }else {
            return 2500 * 2000;
        }
    }
}
