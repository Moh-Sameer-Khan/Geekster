package com.geekster.UserManagementSystem.entity;

public class User {
//    what we need first we add that one in this
    private Integer userId;
    private String name;
    private String userName;
    private String address;
    private Integer phoneNumber;

//    Making the getter and setter for all data members write Or we can use annotation only we can use one at a time

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


//    public User(Integer userId, String name, String userName, String address, int phoneNumber) {
//        this.userId = userId;
//        this.name = name;
//        this.userName = userName;
//        this.address = address;
//        this.phoneNumber = phoneNumber;
//    }

}
