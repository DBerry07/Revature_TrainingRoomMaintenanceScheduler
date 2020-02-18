package com.revature.roommaintenanceprototype.database.table;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Campus {

    @PrimaryKey
    int id;

    @ColumnInfo(name = "name")
    String name;

    //Constructor
    public Campus(int id, String name){
        this.id = id;
        this.name = name;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
