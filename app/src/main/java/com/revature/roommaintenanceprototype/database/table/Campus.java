package com.revature.roommaintenanceprototype.database.table;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;

@Entity
public class Campus {

    @PrimaryKey
    int id;

    String name;

}
