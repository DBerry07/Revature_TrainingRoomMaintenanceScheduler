package com.revature.roommaintenanceprototype.database.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Task {

    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    //CONSTRUCTOR
    public Task(int id, String name){
        this.id = id;
        this.name = name;
    }

    //GETTERS
    public int getId() { return id; }
    public String getName() { return name; }

    //SETTERS
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }

}
