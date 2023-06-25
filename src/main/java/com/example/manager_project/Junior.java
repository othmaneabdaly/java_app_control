package com.example.manager_project;

class Junior extends Manager {

    public Junior(String managerID, String name, float hoursWorked) {
        super(managerID, name, hoursWorked);
    }

    @Override
    float calculercout() {
        if (this.HoursWorked >2500) return 2000*2000+(this.HoursWorked -2000)*3000;
        else if (this.HoursWorked<2500) {
            return this.HoursWorked*1500;
        }else {
            return 2500 * 2000;
        }
    }}