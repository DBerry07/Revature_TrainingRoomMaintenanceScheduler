package com.revature.roommaintenanceprototype.controllers;

import android.app.Activity;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.revature.roommaintenanceprototype.database.api.ApiRequester;
import com.revature.roommaintenanceprototype.database.table.User;
import com.revature.roommaintenanceprototype.database.view_model.UserViewModel;
import com.revature.roommaintenanceprototype.util.DummyText;

import java.util.ArrayList;
import java.util.List;

public class LoginController {

    public static boolean testLoginCredentials(String entryEmail, String entryPassword, List<User> users){
        for (User each : users) {
            if ( entryEmail.equals(each.getEmail()) && entryPassword.equals(each.getPassword()) ) {
                return true;
            }
            /*} else if (entryEmail.equals(DummyText.getTestSiteManagerEmail()) && entryPassword.equals(DummyText.getTestSiteManagerPassword())) {
                return true;
            } else {
                return false;
            }*/
        }
        return false;
    }
}
