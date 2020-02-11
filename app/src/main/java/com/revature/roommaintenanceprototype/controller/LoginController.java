package com.revature.roommaintenanceprototype.controller;

public class LoginController {

    public LoginController(){}

    public boolean processLogin(String email, String password){
        if(email.equals("")) return false;
        if(password.equals("")) return false;
        return true;
    }
}
