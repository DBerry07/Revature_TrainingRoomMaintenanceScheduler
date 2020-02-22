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

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "username")
    String username;

    //Constructor
    public User(int id, int userRole, String email, String username, String password){
        this.id = id;
        this.userRole = userRole;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    //Getters


    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getUserRole() {
        return userRole;
    }

    public String getUsername() { return username; }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) { this.password = password; }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public void setUsername(String username) { this.username = username; }
}
