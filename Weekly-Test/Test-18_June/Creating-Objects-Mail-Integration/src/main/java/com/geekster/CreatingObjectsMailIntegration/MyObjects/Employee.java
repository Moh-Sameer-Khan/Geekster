package com.geekster.CreatingObjectsMailIntegration.MyObjects;

public class Employee {
    //    making a data member
    private String name;

    //    making a constructor for passing a data member
    public Employee(String name) {
        this.name = name;
        //        it's a message who telling this object making or not
        System.out.println("Inside " + this.name + " is a Employee Constructor...Object must have been Created..!!!");
    }

    //    Using the getter and setter for data member
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
