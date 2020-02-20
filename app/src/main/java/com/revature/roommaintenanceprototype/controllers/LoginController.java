package com.revature.roommaintenanceprototype.controllers;

import com.revature.roommaintenanceprototype.util.DummyText;

public class LoginController {

    public static boolean testLoginCredentials(String entryEmail, String entryPassword){
        if( entryEmail.equals(DummyText.getTestTrainerEmail()) && entryPassword.equals(DummyText.getTestTrainerPassword()) ){
            return true;
        }else if( entryEmail.equals(DummyText.getTestSiteManagerEmail()) && entryPassword.equals(DummyText.getTestSiteManagerPassword()) ){
            return true;
        }else{
            return false;
        }
    }
}
