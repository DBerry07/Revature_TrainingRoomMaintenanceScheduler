package com.revature.roommaintenanceprototype.database.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {@ForeignKey(entity = UserRole.class,
                            parentColumns = "id",
                            childColumns = "userRoleId")
        })
public class User {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @NonNull
    @ColumnInfo(name = "userRoleId")
    private int userRoleId;

    /*@NonNull
    @ColumnInfo(name = "password")
    private String password;*/

    //GETTERS
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public int getUserRoleId() {
        return userRoleId;
    }

    //SETTERS
    public void setId(int id) { this.id = id; }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

}
