package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Location {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "name")
    String name;

    //Constructors
    public Location(int id, String name){
        this.id = id;
        this.name = name;
    }

    //Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    //Setters

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
