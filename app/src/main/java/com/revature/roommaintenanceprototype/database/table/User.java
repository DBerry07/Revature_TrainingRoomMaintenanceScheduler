package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "userRole")
    int userRole;

    @ColumnInfo(name = "email")
    String email;

    //Constructor
    public User(int id, int userRole, String email){
        this.id = id;
        this.userRole = userRole;
        this.email = email;
    }

    //Getters


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public int getUserRole() {
        return userRole;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }
}
